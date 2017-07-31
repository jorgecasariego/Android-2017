package jorgecasariego.fragments.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import jorgecasariego.fragments.R;
import jorgecasariego.fragments.comunication.Communicator;
import jorgecasariego.fragments.estatico.EjemploFragmentEstaticoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    Button mContarButton;
    TextView mCerarView;

    Communicator comunicador;
    int contador = 0;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;
        if(context instanceof EjemploFragmentEstaticoActivity){
            activity = (Activity) context;
            comunicador = (Communicator) activity;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        mContarButton = view.findViewById(R.id.contar);
        mCerarView = view.findViewById(R.id.cerar);

        mContarButton.setOnClickListener(this);
        mCerarView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.contar:
                contador++;
                break;
            case R.id.cerar:
                contador = 0;
                break;
        }

        comunicador.enviarAccion(contador);
    }
}
