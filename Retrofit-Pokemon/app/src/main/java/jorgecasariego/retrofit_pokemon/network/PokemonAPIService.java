package jorgecasariego.retrofit_pokemon.network;

import jorgecasariego.retrofit_pokemon.models.PokemonFeed;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jorgecasariego on 6/9/17.
 */

public interface PokemonAPIService {

    @GET("pokemon")
    Call<PokemonFeed> getPokemones();
}
