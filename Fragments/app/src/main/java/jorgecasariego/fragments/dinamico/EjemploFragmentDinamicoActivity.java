package jorgecasariego.fragments.dinamico;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import jorgecasariego.fragments.R;
import jorgecasariego.fragments.fragments.Fragment1;
import jorgecasariego.fragments.fragments.Fragment2;

/**
 * Pasos para el ejemplo de fragments dinamicos:
 *  1. Crear los fragments utilizando el menu del Android Studio
 *  2. Asociamos los fragments con sus layouts en el metodo onCreateView
 *  3. Obtenemos una referencia al FragmentManager en la actividad
 *  4. Comenzamos una transacción
 *  5. Creamos los objetos Fragments dentro de la actividad los cuales serán luego añadidos o reemplazados
 *  6. Añadimos un fragment a través del fragments transaction
 *  7. Hacemos un commit del fragment
 */
public class EjemploFragmentDinamicoActivity extends AppCompatActivity implements View.OnClickListener{

    Button mBoton1;
    Button mBoton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_fragment_dinamico);

        mBoton1 = (Button) findViewById(R.id.boton1);
        mBoton2 = (Button) findViewById(R.id.boton2);

        mBoton1.setOnClickListener(this);
        mBoton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;

        switch (view.getId()){
            case R.id.boton1:
                fragment = new Fragment1();
                break;
            case R.id.boton2:
                fragment = new Fragment2();
                break;
        }

        //Paso 1: Obtener el Fragment Manager de la actividad
        FragmentManager manager = getSupportFragmentManager();

        //Paso 2: Comenzamos una transacción a partir del manage
        FragmentTransaction transaction = manager.beginTransaction();

        //Paso 3: Reemplazamos o añadimos un fragment
        transaction.add(R.id.contenedor, fragment);

        //Paso 4: Hacemos un commit
        transaction.commit();
    }
}
