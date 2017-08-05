package jorgecasariego.ejerciciosrecyclerviews.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jorgecasariego.ejerciciosrecyclerviews.R;

/**
 * Created by jorgecasariego on 3/8/17.
 */

public class AndroidViewHolder extends RecyclerView.ViewHolder{

    ImageView mImagenView;
    TextView mNombreView;

    interface OnItemClickListener {
        public void onClick(AndroidViewHolder holder);
    }

    public AndroidViewHolder(View itemView) {
        super(itemView);

        mImagenView = itemView.findViewById(R.id.imagen);
        mNombreView = itemView.findViewById(R.id.nombre);
    }
}
