package org.brunogama.pokesneer.rest;

import org.brunogama.pokesneer.model.Pokemon;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface PokeAPIInterface {

    @GET("/pokemon/{id}")
    public void fetchPokemon(@Path("id") long id, Callback<Pokemon> pokemonCallback);
}
