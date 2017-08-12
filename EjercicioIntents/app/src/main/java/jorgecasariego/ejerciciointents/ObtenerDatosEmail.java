package jorgecasariego.ejerciciointents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ObtenerDatosEmail extends AppCompatActivity {

    private TextView mCabeceraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtener_datos_email);

        mCabeceraView = (TextView) findViewById(R.id.cabecera);

        // 1. Obtenemos el intent, la acccion y el tipo
        Intent i = getIntent();
        String action = i.getAction();
        String type = i.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null){
            if("text/plain".equals(type)) {
                handleSendText(i);
            }
        }
    }

    private void handleSendText(Intent i) {
        String subject = i.getStringExtra(Intent.EXTRA_SUBJECT);
        if(subject != null){
            mCabeceraView.setText(subject);
        }
    }
}
