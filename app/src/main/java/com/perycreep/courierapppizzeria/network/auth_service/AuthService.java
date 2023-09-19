package com.perycreep.courierapppizzeria.network.auth_service;


import com.perycreep.courierapppizzeria.data.model.User;
import com.perycreep.courierapppizzeria.network.auth_service.LoginRequest.LoginRequest;
import com.perycreep.courierapppizzeria.network.auth_service.LoginRequest.RegistrationRequest;

import retrofit2.Call;
import retrofit2.http.POST;

public interface AuthService {
    @POST("/user/login")
    public Call<User> loginUser(LoginRequest request);

    @POST("/user/registration")
    public Call<User> RegistrationUser(RegistrationRequest request);
}
