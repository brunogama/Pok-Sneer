package com.helabs.pokesneer;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.helabs.pokesneer.model.Pokemon;
import com.helabs.pokesneer.rest.RestClient;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import java.util.Random;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {
    private static String TAG = "MainActivity";
    @Click(R.id.buton)
    void fetchRandomPokemonFromAPI() {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "fetchRandomPokemonFromAPI");
        }

        Random rand = new Random();
        int randomNum = rand.nextInt(BuildConfig.TOTAL_OF_POKEMONS) + 1;

        RestClient.get().fetchPokemon(randomNum, new Callback<Pokemon>() {
            @Override
            public void success(Pokemon pokemon, Response response) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "fetched =" + pokemon);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "error =" + error);
                }
            }
        });
    }
}
