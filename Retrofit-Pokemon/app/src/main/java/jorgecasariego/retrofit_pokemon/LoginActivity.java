package jorgecasariego.retrofit_pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jorgecasariego.retrofit_pokemon.session.SessionManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mUsuarioView;
    EditText mPasswordView;
    Button mIniciarSesionView;
    Button mRegistrarseView;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        mUsuarioView = (EditText) findViewById(R.id.usuario);
        mPasswordView = (EditText) findViewById(R.id.password);
        mIniciarSesionView = (Button) findViewById(R.id.ingresar);
        mRegistrarseView = (Button) findViewById(R.id.registrarse);

        String nombreUsuario = sessionManager.getNombreUsuario();
        mUsuarioView.setText(nombreUsuario);

        mIniciarSesionView.setOnClickListener(this);
        mRegistrarseView.setOnClickListener(this);

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
        String nombre = mUsuarioView.getText().toString();
        String password = mPasswordView.getText().toString();

        if(!nombre.equals("") && !password.equals("")){
            sessionManager.guardarDatosUsuario(nombre, password);
            gotoMain();
        } else {
            Toast.makeText(this, "No puede dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    private void iniciarSesion() {
        String nombre = mUsuarioView.getText().toString();
        String password = mPasswordView.getText().toString();

        if(!nombre.equals("") && !password.equals("")){
            if(sessionManager.esUnUsuarioValido(nombre, password)){
                gotoMain();
            } else {
                Toast.makeText(this, "No es un usuario valido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No puede dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
