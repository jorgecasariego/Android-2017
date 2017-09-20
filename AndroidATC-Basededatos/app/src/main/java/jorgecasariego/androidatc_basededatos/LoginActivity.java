package jorgecasariego.androidatc_basededatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jorgecasariego.androidatc_basededatos.database.DatabaseAdapter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mNombreUsuarioView;
    EditText mPasswordView;
    Button mIniciarSesionView;
    Button mRegistrarseView;

    DatabaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNombreUsuarioView = (EditText) findViewById(R.id.nombre_usuario);
        mPasswordView = (EditText) findViewById(R.id.password);
        mIniciarSesionView = (Button) findViewById(R.id.iniciar);
        mRegistrarseView = (Button) findViewById(R.id.registrarse);

        mIniciarSesionView.setOnClickListener(this);
        mRegistrarseView.setOnClickListener(this);

        // Inicializamos el adaptador
        adapter = new DatabaseAdapter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iniciar:
                iniciarSesion();
                break;
            case R.id.registrarse:
                registrarUsuario();
                break;
        }
    }

    private void iniciarSesion() {
        // Obtenemos los datos del usuario del formulario
        String nombre = mNombreUsuarioView.getText().toString();
        String password = mPasswordView.getText().toString();

        long idRespuesta = adapter.esUsuarioRegistrado(nombre, password);
        if(idRespuesta < 0){
            Toast.makeText(this, "El registro no es un usuario valido", Toast.LENGTH_SHORT).show();
        } else {
            goToMain();
        }
    }

    private void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void registrarUsuario() {
        // Obtenemos los datos del usuario del formulario
        String nombre = mNombreUsuarioView.getText().toString();
        String password = mPasswordView.getText().toString();

        long idRespuesta = adapter.registrarUsuario(nombre, password);
        if(idRespuesta < 0){
            Toast.makeText(this, "El registro no pudo ser realizada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
        }
    }
}
