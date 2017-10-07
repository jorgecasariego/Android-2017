package me.jorgecasariego.proyectogooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class RioMapaActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerRio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rio_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Paso 1: Coordenadas del Pan de Azucar (buscar en Google Maps)
        LatLng rio = new LatLng(-22.949258, -43.154619);

        // Paso 2: Crear un MarkerOption
        MarkerOptions markerOptions = new MarkerOptions()
                .position(rio)
                .title("Pan de Azúcar")
                .snippet("Utilice el metro Botafogo y de ahi caminar.")
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)); // Cambiar el color del icono
                //.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round)); //Usar una imagen en vez del icono normal

        markerRio = mMap.addMarker(markerOptions);

        CameraPosition camara = CameraPosition.builder()
                .target(rio)
                .zoom(14)   //Mientras mas grande mas cerca de la posición
                .build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camara));

        // Al manejar los clicks y hacer draggable true ya no tenemos acceso al mensaje (snippet)
        mMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(markerRio)){
            Toast.makeText(this, "Latitud: " + marker.getPosition().latitude +
                    " - Longitud: " + marker.getPosition().longitude, Toast.LENGTH_SHORT).show();

            return true;
        }

        return false;
    }
}
