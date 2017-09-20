package jorgecasariego.databasewithormlite.database;

import com.j256.ormlite.field.DatabaseField;

/**
 * This class is configured to be determined on to a database by using ORMLite annotations.
 * The @DatabaseField annotations created the fields on the database columns with the columnName
 * id and name.We have created an auto generated integer type primary key named as id.
 *
 * Created by jorgecasariego on 14/9/17.
 */

public class TablaAlumnosAndroid {

    public static final String NOMBRE = "nombre";
    public static final String PASSWORD = "password";

    @DatabaseField(generatedId = true, columnName = "id")
    public int id;

    @DatabaseField(columnName = NOMBRE)
    public String nombre;

    @DatabaseField(columnName = PASSWORD)
    public String password;

    public TablaAlumnosAndroid() {
    }

    public TablaAlumnosAndroid(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
}
