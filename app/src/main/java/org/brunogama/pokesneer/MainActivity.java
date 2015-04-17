package org.brunogama.pokesneer;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.helabs.pokesneer.BuildConfig;
import com.helabs.pokesneer.R;

import org.brunogama.pokesneer.model.Pokemon;
import org.brunogama.pokesneer.rest.RestClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.Random;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
    private static String TAG = "MainActivity";

    @AfterViews
    void init() {
        fetchRandomPokemonFromAPI();
    }

//    @Click(R.id.buton)
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
                startService(getIntent().<Intent>getParcelableExtra("SEND_MESSAGE").setAction(pokemon.toString()));
                finish();
            }

            @Override
            public void failure(RetrofitError error) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "error =" + error);
                }
                finish();
            }
        });
    }

}
