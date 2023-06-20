package com.perycreep.courierapppizzeria.network;

import com.perycreep.courierapppizzeria.network.auth_service.AuthService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Должен быть один объект на все приложение, чтобы не плодить много фоновых процессов
 */
public class NetworkService { //todo Превратить в синглтон
    private static final String URL = "localhost";
    private Retrofit retrofit;
    public AuthService authService;

    public NetworkService() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(
                    GsonConverterFactory.create()
                );
        retrofit = builder
                .client(httpClient.build())
                .build();

        authService = retrofit.create(AuthService.class);
    }
}
