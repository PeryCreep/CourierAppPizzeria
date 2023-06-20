package com.perycreep.courierapppizzeria.network.auth_service;


import com.perycreep.courierapppizzeria.data.model.LoggedInUser;

import retrofit2.Call;
import retrofit2.http.POST;

public interface AuthService {
    @POST("/user/login")
    public Call<LoggedInUser> loginUser();
}
