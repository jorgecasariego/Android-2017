package jorgecasariego.ejerciciointents;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static jorgecasariego.ejerciciointents.MainActivity.NOMBRE;

public class ElegirAmigoActivity extends AppCompatActivity implements View.OnClickListener {

    private String nombreUsuario;

    private TextView usuario;
    private ImageView seleccionarAmigo;
    private TextView amigo;
    private ImageButton mComprarView;
    private ImageButton mLlamarView;
    private ImageButton mEmailView;
    private ImageButton mMapaView;
    private LinearLayout mDatosAmigoView;
    private ImageButton mLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_amigo);

        usuario = (TextView) findViewById(R.id.usuario);
        amigo = (TextView) findViewById(R.id.amigo);

        //Obtenemos el nombre del usuario
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            nombreUsuario = extras.getString(NOMBRE);
            usuario.setText("Bienvenido " + nombreUsuario);
        } else {
            Toast.makeText(this, "Error al obtener usuario", Toast.LENGTH_SHORT).show();
            finish();
        }

        seleccionarAmigo = (ImageView) findViewById(R.id.elegir_amigo);
        seleccionarAmigo.setOnClickListener(this);

        mComprarView = (ImageButton) findViewById(R.id.comprar);
        mLlamarView = (ImageButton) findViewById(R.id.llamar);
        mEmailView = (ImageButton) findViewById(R.id.email);
        mMapaView = (ImageButton) findViewById(R.id.mapa);
        mDatosAmigoView = (LinearLayout) findViewById(R.id.datos_amigo);
        mLogout = (ImageButton) findViewById(R.id.signout);

        mComprarView.setOnClickListener(this);
        mLlamarView.setOnClickListener(this);
        mEmailView.setOnClickListener(this);
        mMapaView.setOnClickListener(this);
        mLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.elegir_amigo:
                seleccionarAmigoInvisble();
                break;
            case R.id.comprar:
                comprarRegalo();
                break;
            case R.id.llamar:
                // Para realizar llamadas es necesario pedir permiso para hacer llamadas
                // 1. Primero en el manifest
                // 2. Segundos para versiones Android 23+ tenemos que controlar el permiso en runtime
                realizarLlamada();
                break;
            case R.id.mapa:
                abrirGoogleMaps();
                break;
            case R.id.email:
                escribirMail();
                break;
            case R.id.signout:
                salir();
                break;
        }
    }

    private void salir() {
        //Preparamos el intent a enviar de vuelta
        Intent datosusuario = new Intent();
        //Ingresamos en el intent una clave y un valor. El valor en este caso es el nombre del usuario
        datosusuario.putExtra(NOMBRE, nombreUsuario);

        //Enviamos el dato a la actividad que nos llamo con resultado OK y retornamos el dato
        setResult(RESULT_OK, datosusuario);

        finish();

    }

    private void escribirMail() {
        String[] direccionesDeCorreo = {"arya@gmail.com", "cersei@hotmail.com", "sansa@altavista.com"};

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Dia de la Amistad");
        i.putExtra(Intent.EXTRA_TEXT, "Quiero comentarles que sus correos han sido hackeados!");
        i.putExtra(Intent.EXTRA_EMAIL, direccionesDeCorreo);

        // Es mejor siempre asegurar que tenemos isntalado alguna aplicación que pueda resolver el
        // intent antes de iniciar la actividad
        if(i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }

    }

    private void abrirGoogleMaps() {
        //Opcion 1: El mapa se centra en la long y lat pasadas
        //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-25.284176, -57.564741"));

        //Opcion 2: Muestra un cuadro de busqueda
        //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-25.284946, -57.564513?q=Shopping"));

        //Opcion 3: Muestra un marcador en la direccion exacta
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-25.284176, -57.564741?q=Palma y 15 de agosto"));

        startActivity(i);
    }

    private void seleccionarAmigoInvisble() {
        String [] amigos = new String[5];

        amigos[0] = "Daenerys Targaryen";
        amigos[1] = "Missandei";
        amigos[2] = "Jorah Mormont";
        amigos[3] = "Tyrion Lannister";
        amigos[4] = "Cersei Lannister";
        amigos[5] = "Jaime Lannister";
        amigos[6] = "Jon Snow";
        amigos[7] = "Sansa Stark";

        Random numeroAleatorio = new Random();
        int numeroElegido = numeroAleatorio.nextInt(8);

        amigo.setText("Tu amigo invisible es " + amigos[numeroElegido]);
        amigo.setVisibility(View.VISIBLE);
        mDatosAmigoView.setVisibility(View.VISIBLE);
        seleccionarAmigo.setImageResource(R.drawable.amigo);

    }

    private void comprarRegalo() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com"));
        startActivity(i);
    }

    private void realizarLlamada() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED){
            checkPermisoLlamada();
        } else {
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0981445566"));
            startActivity(i);
        }
    }

    private void checkPermisoLlamada() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE)){
                /**
                 * Este es el caso en que ya se le mostro anteriormente el permiso y rechazo
                 */
                new AlertDialog.Builder(this)
                        .setTitle("Permiso Requerido")
                        .setMessage("El permiso para llamar fue rechazado anteriormente. Este permiso" +
                                "es requerido para hacer llamadas desde la app. Para continuar es " +
                                "necesario aceptar los permisos dando OK")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.dismiss();
                                ActivityCompat.requestPermissions(ElegirAmigoActivity.this,
                                        new String[]{
                                                android.Manifest.permission.CALL_PHONE
                                        },1);

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            } else {
                /**
                 * Esta es la primera vez que se le muestra
                 */
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
            }
        } else {
            Toast.makeText(this, "El permiso ya ha sido concedido", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo sera invocado cuando el usuario acepta o rechaza un permiso desde el dialogo que
     * se le muestra
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            //Caso en dar o rechazar permiso para llamar desde la app
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // EL permiso fue concedido
                    realizarLlamada();
                } else {
                    String permiso = permissions[0];
                    boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permiso);

                    if(!showRationale){
                        Toast.makeText(this, "Permiso denegado con la opción de nunca mas llamar!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }


}
