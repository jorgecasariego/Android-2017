package jorgecasariego.fragments.estatico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jorgecasariego.fragments.R;
import jorgecasariego.fragments.comunication.Communicator;
import jorgecasariego.fragments.fragments.Fragment2;

public class EjemploFragmentEstaticoActivity extends AppCompatActivity implements Communicator{

    /**
     * Pasos para crear fragments estaticos:
     *  1. Crear los fragments utilizando las opciones del Android Studio
     *  2. Asociamos el fragment con su layout en el metodo onCreateView de c/ fragment
     *  3. Insertamos esos fragments por XML en la activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_fragment_estatico);
    }

    @Override
    public void enviarAccion(int nuevoValor) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragment2.cambiarValorActual(nuevoValor);
    }
}
