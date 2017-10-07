package me.jorgecasariego.proyectogooglemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaMarcadoresActivity extends AppCompatActivity implements OnMapReadyCallback {

    PrimerMapaFragment mPrimerMapaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrimerMapaFragment = PrimerMapaFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map_container, mPrimerMapaFragment)
                .commit();

        mPrimerMapaFragment.getMapAsync(this);
    }

    /**
     * setZoomGesturesEnabled(boolean): Modifica la disponibilidad de los gestos de zoom. Usa false para deshabilitarlos.
     * setScrollGesturesEnabled(boolean): Realiza exactamente que el método anterior pero para los gestos de desplazamiento.
     * setTiltGesturesEnabled(boolean): Igual pero para la inclinación.
     * setRotateGesturesEnabled(boolean): La disponibilidad en gestos de rotación.
     * setAllGesturesEnabled(boolean): Modifica la disponibilidad de todos los gestos al mismo tiempo.
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng asuncionPanteonHeroes = new LatLng(-25.281951, -57.635109);

        googleMap.addMarker(new MarkerOptions()
                .position(asuncionPanteonHeroes)
                .title("Panteón de los Heores"));

        CameraPosition camara = CameraPosition.builder()
                .target(asuncionPanteonHeroes)
                .zoom(15)   //Mientras mas grande mas cerca de la posición
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camara));
    }
}