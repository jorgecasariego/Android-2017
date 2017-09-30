package me.jorgecasariego.notificaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    int idNotificación;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            idNotificación = extras.getInt("id");
        }

        if(idNotificación == 1){
            Toast.makeText(this, "Resultado desde un BigPicture notification!", Toast.LENGTH_SHORT).show();
        } else if(idNotificación == 2){
            Toast.makeText(this, "Esto viene de una notificación con el Texto Grande!", Toast.LENGTH_SHORT).show();
        } else if(idNotificación == 3){
            Toast.makeText(this, "Que muchos mensajes he recibido!", Toast.LENGTH_SHORT).show();
        }
    }
}
