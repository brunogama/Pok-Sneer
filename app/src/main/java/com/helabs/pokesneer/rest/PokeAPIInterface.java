package com.helabs.pokesneer.rest;

import com.helabs.pokesneer.model.Pokemon;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface PokeAPIInterface {

    @GET("/pokemon/{id}")
    public void fetchPokemon(@Path("id") long id, Callback<Pokemon> pokemonCallback);
}
