package jorgecasariego.androidatc_basededatos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jorgecasariego on 12/9/17.
 */

public class DatabaseAdapter {
    private static final String TAG = "DatabaseAdapter";

    // 2. Creamos las variables necesarias para la base de datos
    private static final String DATABASE_NAME = "ANDROID_ATC_DATABASE";
    private static final String TABLE_NAMES = "TABLE_NAMES";
    private static final int DATABASE_VERSION = 1;

    private static final String UID = "_uid";
    private static final String NOMBRE = "nombre";
    private static final String PASSWORD = "password";

    private Context context;
    private MyHelper myHelper;
    private static SQLiteDatabase db;

    // 3. Inicializamos el constructor
    public DatabaseAdapter(Context context) {
        this.context = context;
        myHelper = new MyHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

        // Creamos un metodo para crear la Base de datos
        crearAbrirBaseDatos();
    }

    private void crearAbrirBaseDatos() {
        try {
            db = myHelper.getWritableDatabase();
        } catch (SQLiteException e){
            db = myHelper.getReadableDatabase();
        }

    }

    // Creamos metodo para registrar un usuario a la BD
    public long registrarUsuario(String nombre, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOMBRE, nombre);
        contentValues.put(PASSWORD, password);

        long id = db.insert(TABLE_NAMES, null, contentValues);
        return id;

    }

    public int esUsuarioRegistrado(String nombre, String password){
        // Que columnas voy a necesitar? EL ID del usuario y el nombre
        String columnas[] = {UID, NOMBRE};

        // Creamos la clausula para poder identificar si el usuario es un usuario registrado o no
        // Si existe el usuario el cursor es como un puntero a ese usuario
        Cursor cursor = db.query(TABLE_NAMES,
                columnas,
                NOMBRE + "=? AND " + PASSWORD + "=?",
                new String[]{nombre, password},
                null, null, null);

        // Recorremos el cursor y vemos si existe el usuario
        while (cursor.moveToNext()){
            int uid = cursor.getInt(cursor.getColumnIndex(UID));
            String nombreUsuario = cursor.getString(cursor.getColumnIndex(NOMBRE));

            Log.d(TAG, "esUsuarioRegistrado: Nombre: " + nombreUsuario + " - ID: " + uid);
            return uid;
        }

        return -1;


    }

    private static class MyHelper extends SQLiteOpenHelper{
        private Context mContext;

        // 4. Creamos el query para la creación de la base de datos
        private static final String CREATE_TABLE_NOMBRES =
                " CREATE TABLE " + TABLE_NAMES
                                 + " ( "
                                 + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                 + NOMBRE + " VARCHAR(255), "
                                 + PASSWORD + " VARCHAR(255) "
                                 + ");";

        // 5. Creamos query para eliminar tabla si existe
        private static final String DROP_TABLE_NOMBRES = "DROP TABLE IF EXISTS " + TABLE_NAMES;

        // 1. Constructor de la clase
        // Contexto, nombre de la BD, nombre del cursor y numero de version
        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);

            this.mContext = context;
        }

        /**
         * Metodo llamado para la creación de tablas
         * *****************************************************************************
         * onCreate es ejecutado solo si la base de datos no existe.
         * Si onCreate retorna "Exitosamente" se asume que la base de datos  fue creada
         * con el numero de versión pasado en el constructor de la clase
         * *****************************************************************************
         * @param sqLiteDatabase
         */
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_NOMBRES);
            Log.d(TAG, "onCreate: llamada a crear tabla");
        }

        /**
         * Metodo llamado para la actualización de tablas
         * *****************************************************************************
         * onUpgrade es solo llamado cuando la base de datos existe pero el numero
         * de version de la base de datos es menor que el solicitado por el constructor
         * *****************************************************************************
         */
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            Toast.makeText(mContext, "Actualizando BD", Toast.LENGTH_SHORT).show();

            // Ejecutamos el DROP y luego llamamos al onCreate para que nos cree una nueva tabla
            sqLiteDatabase.execSQL(DROP_TABLE_NOMBRES);
            onCreate(sqLiteDatabase);
        }
    }
}


