package jorgecasariego.databasewithroom;

import android.app.Application;
import android.arch.persistence.room.Room;

import jorgecasariego.databasewithroom.database.MyDatabase;

/**
 * Our last step is create an instance of our database. We can define this in everywhere, but to be
 * a little organized we’ll define it in our Application class.
 *
 * Created by jorgecasariego on 14/9/17.
 */

public class App extends Application {

    public static App INSTANCE;
    private static final String DATABASE_NAME = "ANDROID_DATABASE";
    private static final String PREFERENCES = "RoomDemo.preferences";
    private static final String KEY_FORCE_UPDATE = "force_update";

    private MyDatabase database;

    public static App get(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Create the database
        database = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, DATABASE_NAME)
                .build();

        INSTANCE = this;
    }

    public MyDatabase getDB() {
        return database;
    }
}
