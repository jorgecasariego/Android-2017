package jorgecasariego.rotatescreen;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cedula = (EditText) findViewById(R.id.cedula);
    }

    /**
     * El objeto Configuration representa toda la configuracion actual, no solo los datos que han sido
     * cambiados.
     *
     * Tener en cuenta que cuando declaramos nuestra actividad para que maneje los cambios
     * en la configuracion nosotros somos los responsables de resetear cualquier elemento
     * para la cual proveemos alternativas. Por ejemplo en el caso de imagenes que podrian
     * cambiar en tamaño y forma dependiendo de la orientacion (Landscape o portrait)
     *
     * Si no necesitamos actualizar nuestra aplicación basado en los cambios en la configuracion,
     * se podría no querer implementar este metodo. En tal caso se usaria siempre la misma configuración
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //Chequeamos la orientación de la pantalla
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "La posición es Portrait", Toast.LENGTH_SHORT).show();
        } else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "La orientación es Landscape", Toast.LENGTH_SHORT).show();
        }
    }
}
