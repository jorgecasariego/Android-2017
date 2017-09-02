package jorgecasariego.materialdesign.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import jorgecasariego.materialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    Context mContext;
    Button cambiarColor;
    TextView pantalla;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment1, container, false);

        pantalla = view.findViewById(R.id.fondo);

        cambiarColor = view.findViewById(R.id.button_alerta);
        cambiarColor.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        mostrarAlerta();
    }

    private void mostrarAlerta() {
        //Inicializamos llamando al constructor de alertas: Builder
        AlertDialog.Builder constructorAlerta = new AlertDialog.Builder(mContext);

        // Cremos el mensaje y el titulo
        constructorAlerta.setMessage("¿Esta seguro en cambiar el color del fragment?")
                .setTitle("Ejemplo Dialogs");


        //Agregamos los botones de caso positivo y negativo
        constructorAlerta.setPositiveButton("Cambiar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pantalla.setBackgroundColor(Color.CYAN);
            }
        });

        constructorAlerta.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(mContext, "Opción cancelada", Toast.LENGTH_SHORT).show();
            }
        });

        //Mostramos la alerta
        AlertDialog alerta = constructorAlerta.create();
        alerta.show();
    }
}
