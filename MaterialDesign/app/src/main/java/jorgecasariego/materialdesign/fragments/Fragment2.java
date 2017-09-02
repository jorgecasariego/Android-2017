package jorgecasariego.materialdesign.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jorgecasariego.materialdesign.R;
import jorgecasariego.materialdesign.util.AvisaPersonalizadoDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    Button abrirDialogoActivity;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        abrirDialogoActivity = view.findViewById(R.id.abrir_dialogo_personalizado);
        abrirDialogoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AvisaPersonalizadoDialog.class);
                startActivity(i);
            }
        });

        return view;
    }

}
