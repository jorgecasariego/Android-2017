package jorgecasariego.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import jorgecasariego.fragments.combos.CombosActivity;
import jorgecasariego.fragments.dinamico.EjemploFragmentDinamicoActivity;
import jorgecasariego.fragments.estatico.EjemploFragmentEstaticoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mFragmentsEstaticos;
    Button mFragmentsDinamicos;
    Button mEjercicioCombos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentsEstaticos = (Button) findViewById(R.id.fragments_estaticos);
        mFragmentsDinamicos = (Button) findViewById(R.id.fragments_dinamicos);
        mEjercicioCombos = (Button) findViewById(R.id.ejercicio_combos);

        mFragmentsEstaticos.setOnClickListener(this);
        mFragmentsDinamicos.setOnClickListener(this);
        mEjercicioCombos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.fragments_estaticos:
                intent = new Intent(MainActivity.this, EjemploFragmentEstaticoActivity.class);
                startActivity(intent);
                break;
            case R.id.fragments_dinamicos:
                intent = new Intent(MainActivity.this, EjemploFragmentDinamicoActivity.class);
                startActivity(intent);
                break;
            case R.id.ejercicio_combos:
                intent = new Intent(MainActivity.this, CombosActivity.class);
                startActivity(intent);
                break;
        }
    }
}
