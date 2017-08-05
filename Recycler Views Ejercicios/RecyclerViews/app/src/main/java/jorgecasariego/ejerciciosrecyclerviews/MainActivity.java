package jorgecasariego.ejerciciosrecyclerviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import jorgecasariego.ejerciciosrecyclerviews.modelo.Version;
import jorgecasariego.ejerciciosrecyclerviews.recycler.Adapter;

public class MainActivity extends AppCompatActivity {

    // Paso 1
    RecyclerView mRecyclerView;

    //Paso 4: Creamos un array de datos de prueba
    ArrayList<Version> versionesAndroid = new ArrayList<Version>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Paso 2
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        // Paso 3: Como vamos a posicionar nuestros elementos
        // El recycler view necesita saber como se van a posicionar: podríamos usar
        // LinearLayoutManager, GridLayoutManager o StaggeredGridLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //Paso 4.1: Cargamos el ArrayList
        generarDatos();

        //Paso 5: seteamos el adapter con el recyclerview
        mRecyclerView.setAdapter(new Adapter(this, versionesAndroid));

    }

    private void generarDatos() {
        versionesAndroid.add(new Version("Cupcake", R.drawable.android1));
        versionesAndroid.add(new Version("Donut", R.drawable.android2));
        versionesAndroid.add(new Version("Eclair", R.drawable.android3));
        versionesAndroid.add(new Version("Froyo", R.drawable.android4));
        versionesAndroid.add(new Version("Gingerbread", R.drawable.android5));
        versionesAndroid.add(new Version("Honeycomb", R.drawable.android6));
        versionesAndroid.add(new Version("Ice Cream Sandwich", R.drawable.android7));
        versionesAndroid.add(new Version("JellyBean", R.drawable.android8));
        versionesAndroid.add(new Version("Kitkat", R.drawable.android9));
        versionesAndroid.add(new Version("Lollipop", R.drawable.android10));
        versionesAndroid.add(new Version("Marshmallow", R.drawable.android11));
    }
}
