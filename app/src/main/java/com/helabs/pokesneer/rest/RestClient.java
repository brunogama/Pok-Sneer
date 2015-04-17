package com.helabs.pokesneer.rest;


import com.helabs.pokesneer.BuildConfig;

import retrofit.RestAdapter;

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
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BuildConfig.SERVER_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(PokeAPIInterface.class);
    }
}

