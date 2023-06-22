package com.perycreep.courierapppizzeria.network.auth_service.LoginRequest;

public class LoginRequest {

    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
