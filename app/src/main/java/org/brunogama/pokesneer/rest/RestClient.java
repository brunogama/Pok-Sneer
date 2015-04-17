package org.brunogama.pokesneer.rest;

import com.squareup.okhttp.OkHttpClient;

import org.brunogama.pokesneer.BuildConfig;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {
    private static PokeAPIInterface REST_CLIENT;

    static {
        setupRestClient();
    }

    private RestClient() { }

    public static PokeAPIInterface get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter.LogLevel logLevel = BuildConfig.DEBUG ? RestAdapter.LogLevel.BASIC : RestAdapter.LogLevel.NONE;
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BuildConfig.SERVER_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(logLevel);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(PokeAPIInterface.class);
    }
}

