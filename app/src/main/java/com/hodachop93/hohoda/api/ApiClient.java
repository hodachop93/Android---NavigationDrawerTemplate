package com.hodachop93.hohoda.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hop on 08/03/2016.
 */
public class ApiClient {
    private static Retrofit retrofit;

    private static String BASE_URL = "http://192.168.1.5:8080/api";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
