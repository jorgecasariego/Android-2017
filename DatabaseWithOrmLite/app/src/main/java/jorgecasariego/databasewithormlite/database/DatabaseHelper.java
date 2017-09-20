package jorgecasariego.databasewithormlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * This class is extended from OrmLiteSqliteOpenHelper.
 * We have to override two methods, onCreate() and onUpgrade() .onCreate() method includes the
 * table creation statements and other first-time configuration logics and onUpgrade() method
 * is used for any update in the database.
 *
 * In this class we have created DAO method, it is a most important keyword in ORMLite to
 * handle the database.Create, delete, read, and the update will be done through DAOs.
 *
 * Created by jorgecasariego on 15/9/17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String DB_NAME = "android_collegues.db";
    private static final int DB_VERSION = 1;
    private Dao<TablaAlumnosAndroid, Integer> tablaAlumnosAndroidsDao;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, TablaAlumnosAndroid.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, TablaAlumnosAndroid.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        onCreate(database);
    }

    public Dao<TablaAlumnosAndroid, Integer> getTablaAlumnosAndroidsDao() throws SQLException, SQLException {
        if(tablaAlumnosAndroidsDao == null){
            tablaAlumnosAndroidsDao = getDao(TablaAlumnosAndroid.class);
        }

        return tablaAlumnosAndroidsDao;
    }
}
