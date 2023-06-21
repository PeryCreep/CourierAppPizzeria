package com.perycreep.courierapppizzeria.network;

import com.perycreep.courierapppizzeria.network.auth_service.AuthService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Должен быть один объект на все приложение, чтобы не плодить много фоновых процессов
 */
public class NetworkService {
    private static NetworkService INSTANCE;
    private static final String URL = "localhost";
    private Retrofit retrofit;
    public AuthService authService;

    private NetworkService() {
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

    public static synchronized NetworkService getRestAdapter() {
        if(INSTANCE == null) {
            INSTANCE = new NetworkService();
        }
        return INSTANCE;
    }
}
