package androidatc.suma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private EditText numero1View;
    private EditText numero2View;
    private Button sumarView;
    private TextView resultadoView;
    private TextView acercaDeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1View = (EditText) findViewById(R.id.numero1);
        numero2View = (EditText) findViewById(R.id.numero2);
        sumarView = (Button) findViewById(R.id.boton_sumar);
        resultadoView = (TextView) findViewById(R.id.resultado);
        acercaDeView = (TextView) findViewById(R.id.acerca_de);

        sumarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumar();
            }
        });

        acercaDeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAcercaDe();
            }
        });
    }

    private void sumar(){
        int numero1 = Integer.valueOf(numero1View.getText().toString());
        int numero2 = Integer.valueOf(numero2View.getText().toString());

        Log.d(TAG, "El usuario ingreso los valores " + numero1 + " - " + numero2);

        int resultadoSuma = numero1 + numero2;

        resultadoView.setText("La suma es " + resultadoSuma);
    }

    private void goToAcercaDe(){
        Intent i = new Intent(this, AcercaDeActivity.class);
        startActivity(i);
    }
}
