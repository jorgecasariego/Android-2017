package jorgecasariego.ejemplosrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.R;
import jorgecasariego.ejemplosrecyclerview.listener.RecyclerItemClickListener;
import jorgecasariego.ejemplosrecyclerview.model.Picture;

/**
 * Created by jorgecasariego on 4/8/17.
 */

public class AdapterExample extends RecyclerView.Adapter<AdapterExample.ExampleHolder> {

    private ArrayList<Picture> pictureArrayList;
    private int itemLayout;
    private RecyclerItemClickListener listener;

    public void setRecyclerItemClickListener(RecyclerItemClickListener listener){
        this.listener = listener;
    }

    public AdapterExample() {
    }

    public AdapterExample(ArrayList<Picture> pictureArrayList, int itemLayout) {
        this.pictureArrayList = pictureArrayList;
        this.itemLayout = itemLayout;
    }

    @Override
    public AdapterExample.ExampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new ExampleHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterExample.ExampleHolder holder, int position) {
        final Picture picture = pictureArrayList.get(position);
        holder.titulo.setText(picture.getName());
        holder.imagen.setImageResource(picture.getImage());
    }

    @Override
    public int getItemCount() {
        return pictureArrayList.size();
    }

    public class ExampleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titulo;
        ImageView imagen;

        public ExampleHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.titulo);
            imagen = itemView.findViewById(R.id.imagen);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onItemClickListener(getAdapterPosition());
            }
        }
    }
}
