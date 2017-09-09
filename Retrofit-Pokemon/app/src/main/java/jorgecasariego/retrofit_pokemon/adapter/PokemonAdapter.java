package jorgecasariego.retrofit_pokemon.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jorgecasariego.retrofit_pokemon.R;
import jorgecasariego.retrofit_pokemon.listeners.RecyclerViewClickListener;
import jorgecasariego.retrofit_pokemon.models.Result;

/**
 * Created by jorgecasariego on 6/9/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private List<Result> listaPokemones;
    private RecyclerViewClickListener listener;

    public PokemonAdapter() {
        this.listaPokemones = new ArrayList<>();
    }

    public void setRecyclerItemClickListener(RecyclerViewClickListener listener){
        this.listener = listener;
    }

    public void swap(List<Result> nuevaLista){
        listaPokemones.clear();
        listaPokemones.addAll(nuevaLista);
        notifyDataSetChanged();
    }

    @Override
    public PokemonAdapter.PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.pokemon_row, parent, false);

        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonViewHolder holder, int position) {
        // Obtenemos el pokemon en la posición 'position'
        final Result pokemon = listaPokemones.get(position);
        holder.nombreView.setText(pokemon.getName());
    }

    @Override
    public int getItemCount() {
        return listaPokemones.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombreView;
        private ImageView icon;

        public PokemonViewHolder(View itemView) {
            super(itemView);

            nombreView = itemView.findViewById(R.id.nombre);
            icon = itemView.findViewById(R.id.icon);

            Random r = new Random();
            int numero = r.nextInt(99) + 1;

            if(numero % 2 == 0){
                icon.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.pikachu));
            } else if(numero % 3 == 0){
                icon.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.psyduck));
            }else if(numero % 5 == 0){
                icon.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.snorlax));
            } else if(numero % 7 == 0){
                icon.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.squirtle));
            } else if(numero % 11 == 0){
                icon.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.fist));
            } else {
                icon.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.tornado));
            }

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onClick(getAdapterPosition());
            }
        }
    }
}
