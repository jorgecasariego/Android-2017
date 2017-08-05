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

public class AdapterExampleTypes extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Picture> pictureArrayList;
    private int itemLayout;
    private static final int TYPE_ITEM_1 = 0;
    private static final int TYPE_ITEM_2 = 1;
    private static final int TYPE_ITEM_3 = 2;
    private RecyclerItemClickListener listener;

    public void setRecyclerItemClickListener(RecyclerItemClickListener listener){
        this.listener = listener;
    }

    public AdapterExampleTypes() {
    }

    public AdapterExampleTypes(ArrayList<Picture> pictureArrayList, int itemLayout) {
        this.pictureArrayList = pictureArrayList;
        this.itemLayout = itemLayout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case TYPE_ITEM_1:
                View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
                viewHolder = new ExampleHolder(view);
                break;
            case TYPE_ITEM_2:
                viewHolder = new ExampleHolderTypeTwo(inflater.inflate(R.layout.item_type_four, parent, false));
                break;
            case TYPE_ITEM_3:
                viewHolder = new ExampleHolderTypeThree(inflater.inflate(R.layout.item_type_five, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Picture picture = pictureArrayList.get(position);

        switch (holder.getItemViewType()){
            case TYPE_ITEM_1:
                setTypeItem1((ExampleHolder) holder, picture);
                break;
            case TYPE_ITEM_2:
                setTypeItem2((ExampleHolderTypeTwo) holder, picture);
                break;
            case TYPE_ITEM_3:
                setTypeItem3((ExampleHolderTypeThree) holder, picture);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onItemClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictureArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 3 == 0){
            return TYPE_ITEM_2;
        } else if (position % 2 == 0) {
            return TYPE_ITEM_3;
        }

        return TYPE_ITEM_1;
    }

    public class ExampleHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView imagen;
        View view;

        public ExampleHolder(View itemView) {
            super(itemView);
            view = itemView;

            titulo = itemView.findViewById(R.id.titulo);
            imagen = itemView.findViewById(R.id.imagen);

        }
    }

    public static class ExampleHolderTypeTwo extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView imagen;
        View view;

        public ExampleHolderTypeTwo(View itemView) {
            super(itemView);
            view = itemView;

            titulo = itemView.findViewById(R.id.titulo);
            imagen = itemView.findViewById(R.id.imagen);
        }

    }

    public static class ExampleHolderTypeThree extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView imagen;
        View view;

        public ExampleHolderTypeThree(View itemView) {
            super(itemView);
            view = itemView;

            titulo = itemView.findViewById(R.id.titulo);
            imagen = itemView.findViewById(R.id.imagen);

        }


    }

    private void setTypeItem1(ExampleHolder holder, Picture picture) {
        holder.titulo.setText(picture.getName());
        holder.imagen.setImageResource(picture.getImage());
    }

    private void setTypeItem2(ExampleHolderTypeTwo holder, Picture picture) {
        holder.titulo.setText(picture.getName());
        holder.imagen.setImageResource(picture.getImage());
    }

    private void setTypeItem3(ExampleHolderTypeThree holder, Picture picture) {
        holder.titulo.setText(picture.getName());
        holder.imagen.setImageResource(picture.getImage());
    }
}
