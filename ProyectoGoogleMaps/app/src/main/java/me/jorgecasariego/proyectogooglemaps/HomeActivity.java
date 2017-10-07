package me.jorgecasariego.proyectogooglemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button mBoton1;
    Button mBoton2;
    Button mBoton3;
    Button mBoton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mBoton1 = (Button) findViewById(R.id.marker);
        mBoton2 = (Button) findViewById(R.id.settings);
        mBoton3 = (Button) findViewById(R.id.controles);
        mBoton4 = (Button) findViewById(R.id.rioMarker);


        mBoton1.setOnClickListener(this);
        mBoton2.setOnClickListener(this);
        mBoton3.setOnClickListener(this);
        mBoton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.marker:
                verMapaMarcadores();
                break;
            case R.id.settings:
                verSydney();
                break;
            case R.id.controles:
                veControles();
                break;
            case R.id.rioMarker:
                agregarMarker();
                break;
        }
    }

    private void agregarMarker() {
        Intent i = new Intent(this, RioMapaActivity.class);
        startActivity(i);
    }

    private void veControles() {
        Intent i = new Intent(this, ControlesMapActivity.class);
        startActivity(i);
    }

    private void verSydney() {
        Intent i = new Intent(this, SydneyMapActivity.class);
        startActivity(i);
    }

    private void verMapaMarcadores() {
        Intent i = new Intent(this, MapaMarcadoresActivity.class);
        startActivity(i);
    }
}
