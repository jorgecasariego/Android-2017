package me.jorgecasariego.proyectogooglemaps;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;


public class PrimerMapaFragment extends SupportMapFragment {

    public PrimerMapaFragment() {
    }

    public static PrimerMapaFragment newInstance() {
        PrimerMapaFragment fragment = new PrimerMapaFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = super.onCreateView(inflater, container, savedInstanceState);

        return root;
    }

}
