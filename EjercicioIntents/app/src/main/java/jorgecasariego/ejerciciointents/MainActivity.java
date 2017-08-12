package jorgecasariego.ejerciciointents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String NOMBRE = "Nombre";
    public static final int REQUEST_CODE = 1;

    EditText nombre;
    EditText password;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        password = (EditText) findViewById(R.id.password);
        ingresar = (Button) findViewById(R.id.ingresar);
        ingresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String miNombre = nombre.getText().toString();
        String miPassword = password.getText().toString();

        if(miNombre.equals("admin") && miPassword.equals("12345")){
            Intent intent = new Intent(this, ElegirAmigoActivity.class);
            intent.putExtra(NOMBRE, miNombre);
            startActivityForResult(intent, REQUEST_CODE);
        } else {
            Toast.makeText(this, "Usuario y contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE:
                if(resultCode == RESULT_OK){
                    Bundle datos = data.getExtras();
                    if(datos != null){
                        String usuario = datos.getString(NOMBRE);
                        Toast.makeText(this, usuario + " gracias por ser un buen amigo!!", Toast.LENGTH_SHORT).show();
                        nombre.setText(datos.getString(NOMBRE));
                        password.setText("");
                    }
                }
                break;
        }
    }
}
