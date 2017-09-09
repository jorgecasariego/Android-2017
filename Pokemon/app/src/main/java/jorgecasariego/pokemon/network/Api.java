package jorgecasariego.pokemon.network;

/**
 * Created by jorgecasariego on 9/9/17.
 */

public class Api {
    private static final String POKEMON_URL_BASE = "http://pokeapi.co/api/v2/";

    public static PokemAPiService getApiService(){
        return RetrofitClient
                .getCliente(POKEMON_URL_BASE)
                .create(PokemAPiService.class);
    }
}
