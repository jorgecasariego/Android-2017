package jorgecasariego.databasewithormlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;

import jorgecasariego.databasewithormlite.database.TablaAlumnosAndroid;
import jorgecasariego.databasewithormlite.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mNombreUsuarioView;
    EditText mPasswordView;
    Button mIniciarSesionView;
    Button mRegistrarseView;

    //We can interact with SQLite database only through the DAOs which are the part of
    // DatatabaseHelper class, so at first, we are taking a reference to that class.
    // Then we create an object of AndroidDatabase for insert data to the database.
    private DatabaseHelper databaseHelper = null;

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
        int count = 0;

        try {
            Dao<TablaAlumnosAndroid, Integer> tablaAlumnosAndroidsDao = getHelper().getTablaAlumnosAndroidsDao();

            PreparedQuery<TablaAlumnosAndroid> preparedQuery = tablaAlumnosAndroidsDao
                    .queryBuilder()
                    .where()
                    .eq(TablaAlumnosAndroid.NOMBRE, nombre)
                    .and()
                    .eq(TablaAlumnosAndroid.PASSWORD, password)
                    .prepare();

            // Query for and return the first item in the object table which matches the PreparedQuery.
            // This can be used to return the object that matches a single unique column.
            TablaAlumnosAndroid androidDatabase = tablaAlumnosAndroidsDao.queryForFirst(preparedQuery);

            if(androidDatabase != null){
                goToMain();
            } else {
                Toast.makeText(this, "El registro no es un usuario valido", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // We initialize Database_Helper for future use.
    private DatabaseHelper getHelper(){
        if(databaseHelper == null){
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }

        return databaseHelper;
    }

    private void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void registrarUsuario() {
        // Obtenemos los datos del usuario del formulario
        String nombre = mNombreUsuarioView.getText().toString();
        String password = mPasswordView.getText().toString();

        TablaAlumnosAndroid androidDatabase = new TablaAlumnosAndroid(nombre, password);

        try {
            final Dao<TablaAlumnosAndroid, Integer> tablaAlumnosAndroidsDao = getHelper().getTablaAlumnosAndroidsDao();

            // Create a new row in the database from an object. If the object being created uses
            // {@link DatabaseField#generatedId()} then the data parameter will be modified and set
            // with the corresponding id from the database.
            int idResultado = tablaAlumnosAndroidsDao.create(androidDatabase);

            if (idResultado < 0) {
                Toast.makeText(this, "El registro no pudo ser realizada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
                goToMain();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(databaseHelper != null){
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
