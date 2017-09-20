package jorgecasariego.databasewithroom.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import jorgecasariego.databasewithroom.daos.UsuarioDAO;
import jorgecasariego.databasewithroom.entities.Usuario;

/**
 * This will be the bridge between our app and SQLite.
 * We must to create an abstract class and extend it of RoomDatabase class.
 *
 * Also, we have to add Database annotation in order to identify this class as your database.
 * This annotation contains some properties:
 *
 *  - entities: defines the related entities of the current database. If you have more than one,
 *              you can separate by comma.
 *
 *  - version: defines the database version
 *
 *  In addition, we have to declare the DAO’s as an abstract methods.
 *
 * Created by jorgecasariego on 14/9/17.
 */
@Database(entities = {Usuario.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase{
    public abstract UsuarioDAO usuarioDAO();
}
