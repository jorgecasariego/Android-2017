package jorgecasariego.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import jorgecasariego.pokemon.models.PokemonRespuesta;
import jorgecasariego.pokemon.network.Api;
import jorgecasariego.pokemon.network.PokemAPiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView respuestaView;
    PokemAPiService pokemonApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        respuestaView = (TextView) findViewById(R.id.respuesta);

        pokemonApiService = Api.getApiService();

        getPokemones();
    }

    private void getPokemones() {
        Call<PokemonRespuesta> pokemones = pokemonApiService.getPokemones();

        pokemones.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                PokemonRespuesta respuesta = response.body();

                respuestaView.setText("Respuesta: " + respuesta.getResults().toString());

            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo al obtener Pokemones", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
