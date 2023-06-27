package com.perycreep.courierapppizzeria.network.auth_service.LoginRequest;

public class RegistrationRequest {

    private String username;
    private String email;
    private String password;

    public RegistrationRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
