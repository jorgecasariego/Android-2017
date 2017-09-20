package jorgecasariego.databasewithroom;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jorgecasariego.databasewithroom.entities.Usuario;

public class LoginActivity extends LifecycleActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";

    EditText mNombreUsuarioView;
    EditText mPasswordView;
    Button mIniciarSesionView;
    Button mRegistrarseView;

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

        LiveData<Usuario> usuarioLiveData = App.get().getDB().usuarioDAO().findUsuarioByNamePassword(nombre, password);
        usuarioLiveData.observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(@Nullable Usuario usuario) {
                if(usuario != null){
                    Log.d(TAG, "onChanged: el usuario es " + usuario.toString());
                    goToMain();
                } else {
                    Toast.makeText(LoginActivity.this, "Los datos de acceso no son los correctos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void registrarUsuario() {
        final long[] idRespuesta = new long[1];

        // Obtenemos los datos del usuario del formulario
        String nombre = mNombreUsuarioView.getText().toString();
        String password = mPasswordView.getText().toString();

        final Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setPassword(password);

        /**
         * Room does not allow accessing the database on the main thread unless you called
         * allowMainThreadQueries() on the builder because it might potentially lock the UI
         * for a long periods of time. Asynchronous queries (queries that return LiveData or
         * RxJava Flowable) are exempt from this rule since they asynchronously run the query
         * on a background thread when needed.
         *
         */
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                idRespuesta[0] = App.get().getDB().usuarioDAO().registrarUsuario(nuevoUsuario);
                return null;
            }
        }.execute();



        if(idRespuesta[0] < 0){
            Toast.makeText(this, "El registro no pudo ser realizada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
        }
    }
}
