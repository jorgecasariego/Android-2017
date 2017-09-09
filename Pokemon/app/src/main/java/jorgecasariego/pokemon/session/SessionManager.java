package jorgecasariego.pokemon.session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jorgecasariego on 9/9/17.
 */

public class SessionManager {
    // 1. SharedPreferences
    SharedPreferences sharedPreferences;

    //2. Editor para editar el sharedPreferences
    SharedPreferences.Editor editor;

    //3. Contexto
    Context context;

    // 4. Modo en que vamos a abrir el sharedPreferences
    int PRIVATE_MODE = 0;

    // 5. Nombre de nuestro SP
    private static final String NOMBRE_SHARED_PREFERENCES = "Pokemon_Pref";

    // 6. Las claves que vamos a utilizar para guardar el nombre y password
    private static final String KEY_NOMBRE = "NOMBRE";
    private static final String KEY_PASSWORD = "PASSWORD";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences =
                context.getSharedPreferences(
                        NOMBRE_SHARED_PREFERENCES,
                        Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();
    }

    public void guardarDatosUsuario(String nombre, String password){
        editor.putString(KEY_NOMBRE, nombre);
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public boolean esUnUsuarioValido(String nombre, String password){
        if(nombre.equals(sharedPreferences.getString(KEY_NOMBRE, ""))
                && password.equals(sharedPreferences.getString(KEY_PASSWORD, ""))){
            return  true;
        } else {
            return false;
        }
    }
}













