package com.perycreep.courierapppizzeria.ui.login;

import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.perycreep.courierapppizzeria.data.model.User;
import com.perycreep.courierapppizzeria.databinding.ActivityLoginBinding;
import com.perycreep.courierapppizzeria.network.NetworkService;
import com.perycreep.courierapppizzeria.network.auth_service.LoginRequest.LoginRequest;
import com.perycreep.courierapppizzeria.ui.orders.OrderActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

            if(TextUtils.isEmpty(usernameText) || TextUtils.isEmpty(passwordText)){
                Toast.makeText(LoginActivity.this, "Введите логин или пароль",Toast.LENGTH_LONG).show();
            }
            else {
                NetworkService.getRestAdapter().authService.loginUser(new LoginRequest(usernameText, passwordText)).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Вошли ", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginActivity.this,OrderActivity.class));
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Вход запрещен",Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Throwable" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    public void goToRegActivity(View v){
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
}