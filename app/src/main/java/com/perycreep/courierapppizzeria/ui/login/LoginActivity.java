package com.perycreep.courierapppizzeria.ui.login;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.perycreep.courierapppizzeria.databinding.ActivityLoginBinding;
import com.perycreep.courierapppizzeria.network.NetworkService;
import com.perycreep.courierapppizzeria.network.auth_service.LoginRequest.LoginRequest;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button loginButton = binding.login;

        loginButton.setOnClickListener(view -> {
            String usernameText = binding.username.getText().toString();
            String passwordText = binding.password.getText().toString();
           NetworkService.getRestAdapter().authService.loginUser(new LoginRequest(usernameText, passwordText));
        });


    }
}