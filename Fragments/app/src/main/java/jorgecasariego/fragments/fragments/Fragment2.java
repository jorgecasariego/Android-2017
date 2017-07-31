package jorgecasariego.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jorgecasariego.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    TextView mValorActual;
    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        mValorActual = view.findViewById(R.id.valor_actual);

        return view;
    }

    public void cambiarValorActual(int nuevoValor){

        mValorActual.setText(" - " + nuevoValor + " - ");
    }

}
