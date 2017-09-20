package jorgecasariego.databasewithroom.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import jorgecasariego.databasewithroom.entities.Usuario;

/**
 * URL: https://developer.android.com/topic/libraries/architecture/room.html#db-migration
 *
 * This interface will contain the main operations we can do on our database
 *
 * Created by jorgecasariego on 14/9/17.
 */
@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuario")
    List<Usuario> getUsuarios();

    @Query("SELECT * FROM usuario WHERE  nombre = :nombre AND password = :password")
    LiveData<Usuario> findUsuarioByNamePassword(String nombre, String password);

    /**
     * @param usuario
     * @return If the @Insert method receives only 1 parameter, it can return a long,
     * which is the new rowId for the inserted item. If the parameter is an array or a collection,
     * it should return long[] or List<Long> instead.
     */
    @Insert
    long registrarUsuario(Usuario usuario);

    /**
     * Although usually not necessary, you can have this method return an int value instead,
     * indicating the number of rows updated in the database
     * @param usuario
     */
    @Update
    void actualizarUsuario(Usuario usuario);

    /**
     * Although usually not necessary, you can have this method return an int value instead,
     * indicating the number of rows removed from the database
     * @param usuario
     */
    @Delete
    void borrarUsuario(Usuario usuario);
}
