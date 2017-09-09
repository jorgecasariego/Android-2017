package jorgecasariego.pokemon.network;

import jorgecasariego.pokemon.models.PokemonRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jorgecasariego on 9/9/17.
 */

public interface PokemAPiService {

    @GET("pokemon")
    Call<PokemonRespuesta> getPokemones();
}
