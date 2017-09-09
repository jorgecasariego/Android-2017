package jorgecasariego.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jorgecasariego.pokemon.session.SessionManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombreView;
    EditText passwordView;
    Button ingresarView;
    Button registrarseView;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        nombreView = (EditText) findViewById(R.id.nombre);
        passwordView = (EditText) findViewById(R.id.password);

        ingresarView = (Button) findViewById(R.id.ingresar);
        registrarseView = (Button) findViewById(R.id.registrarse);

        ingresarView.setOnClickListener(this);
        registrarseView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ingresar:
                iniciarSesion();
                break;
            case R.id.registrarse:
                registrarUsuario();
                break;
        }
    }

    private void registrarUsuario() {
        String nombre = nombreView.getText().toString();
        String password = passwordView.getText().toString();

        if(!nombre.equals("") && !password.equals("")){
            //guardar en sharedPreferences los valores del usuario
            sessionManager.guardarDatosUsuario(nombre, password);
            gotoMainActivity();
        } else {
            Toast.makeText(this, "No se pueden dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void iniciarSesion() {
        String nombre = nombreView.getText().toString();
        String password = passwordView.getText().toString();

        if(!nombre.equals("") && !password.equals("")){
            // obtener los valores del sharedPreferences y verificar que sean
            // iguales a los valores que ingreso el usuario
            if(sessionManager.esUnUsuarioValido(nombre, password)){
                gotoMainActivity();
            } else {
                Toast.makeText(this, "Usuario y contraseña no valida", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No se pueden dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
    }


}
