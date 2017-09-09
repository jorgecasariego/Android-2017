package jorgecasariego.retrofit_pokemon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import jorgecasariego.retrofit_pokemon.adapter.PokemonAdapter;
import jorgecasariego.retrofit_pokemon.listeners.RecyclerViewClickListener;
import jorgecasariego.retrofit_pokemon.models.PokemonFeed;
import jorgecasariego.retrofit_pokemon.models.Result;
import jorgecasariego.retrofit_pokemon.network.ApiUtils;
import jorgecasariego.retrofit_pokemon.network.PokemonAPIService;
import jorgecasariego.retrofit_pokemon.session.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener, View.OnClickListener {
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private FloatingActionButton logoutView;

    // Agregamos el Pokemon Adapter
    private PokemonAdapter adapter;
    private ArrayList<Result> listaPokemones = new ArrayList<>();
    private PokemonAPIService mApiService;

    private TextView mNombreUsuario;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);

        mNombreUsuario = (TextView) findViewById(R.id.nombre_usuario);
        mNombreUsuario.setText("Bievenido " + sessionManager.getNombreUsuario());

        logoutView = (FloatingActionButton) findViewById(R.id.logout);
        logoutView.setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new PokemonAdapter();
        adapter.setRecyclerItemClickListener(this);
        mRecyclerView.setAdapter(adapter);

        mApiService = ApiUtils.getAPIService();

        getPokemons();
    }

    private void getPokemons() {
        // Parte 1
        Call<PokemonFeed> call = mApiService.getPokemones();

        //Parte 2
        call.enqueue(new Callback<PokemonFeed>() {

            // Caso Exito
            @Override
            public void onResponse(Call<PokemonFeed> call, Response<PokemonFeed> response) {
                switch (response.code()){
                    case 200:
                        PokemonFeed respuesta = response.body();
                        listaPokemones = (ArrayList<Result>) respuesta.getResults();
                        adapter.swap(listaPokemones);
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            // Caso Fallo
            @Override
            public void onFailure(Call<PokemonFeed> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo al obtener pokemones!", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Mensaje error: " + t.getMessage());
            }
        });
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, "Abrir pokemon " + listaPokemones.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        logout();
    }

    private void logout() {
        sessionManager.logout();
        finish();
    }
}
