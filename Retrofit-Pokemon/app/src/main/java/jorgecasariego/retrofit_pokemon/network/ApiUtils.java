package jorgecasariego.retrofit_pokemon.network;

/**
 * Created by jorgecasariego on 6/9/17.
 *
 * Esta clase tendrá la URL base como una variable estática y también proporcionará la interfaz
 * PokemonAPIService con un método estático getAPIService() al resto de nuestra aplicación.
 */

public class ApiUtils {
    private static final String POKEMON_BASE_URL = "http://pokeapi.co/api/v2/";

    public static PokemonAPIService getAPIService() {

        return RetrofitClient.getClient(POKEMON_BASE_URL)
                .create(PokemonAPIService.class);
    }
}

