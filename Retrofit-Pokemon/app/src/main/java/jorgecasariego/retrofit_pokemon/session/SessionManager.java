package jorgecasariego.retrofit_pokemon.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import jorgecasariego.retrofit_pokemon.LoginActivity;

/**
 * Created by jorgecasariego on 7/9/17.
 */

public class SessionManager {
    // 1. SharedPreferences
    SharedPreferences sharedPreferences;

    // 2. Editor para editar el SharedPreferences
    Editor editor;

    // 3. Context
    Context context;

    // 4. En que modo vamos a utilizar nuestro SharedPreferences
    int PRIVATE_MODE = 0;

    // 5. Nombre del SharedPreferences
    private static final String NOMBRE_PREF = "PokemonPref";

    // 6. Claves que utilizaremos para acceder a los valores
    private static final String KEY_NOMBRE = "NOMBRE";
    private static final String KEY_PASSWORD = "PASSWORD";

    // 7. Constructor
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(NOMBRE_PREF, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    // 8. Metodo para almacenar los datos de Login del usuario
    public void guardarDatosUsuario(String nombre, String password){
        editor.putString(KEY_NOMBRE, nombre);
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public boolean esUnUsuarioValido(String nombre, String password){
        if(nombre.equals(sharedPreferences.getString(KEY_NOMBRE, ""))
                && password.equals(sharedPreferences.getString(KEY_PASSWORD, ""))){
            return true;
        } else {
            return false;
        }
    }

    public String getNombreUsuario(){
        return sharedPreferences.getString(KEY_NOMBRE, "");
    }

    public void logout(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
    }
}
