package jorgecasariego.ejerciciosrecyclerviews.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import jorgecasariego.ejerciciosrecyclerviews.R;
import jorgecasariego.ejerciciosrecyclerviews.modelo.Version;

/**
 * Created by jorgecasariego on 3/8/17.
 */

public class Adapter extends RecyclerView.Adapter<AndroidViewHolder> {

    private Context context;
    private ArrayList<Version> versionesAndroidList;



    public Adapter(Context context, ArrayList<Version> versionesAndroidList) {
        this.context = context;
        this.versionesAndroidList = versionesAndroidList;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new AndroidViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        // Obtengo la version de android en el arraylist segun la posición
        Version androidVersion = versionesAndroidList.get(position);

        // Seteo la vista con el modelo obtenido
        holder.mNombreView.setText(androidVersion.getNombre());
        holder.mImagenView.setImageResource(androidVersion.getIdImagen());
    }

    @Override
    public int getItemCount() {
        return versionesAndroidList.size();
    }
}
