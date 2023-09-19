package com.perycreep.courierapppizzeria.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.perycreep.courierapppizzeria.R;
import com.perycreep.courierapppizzeria.data.model.User;
import com.perycreep.courierapppizzeria.databinding.ActivityRegistrationBinding;
import com.perycreep.courierapppizzeria.network.NetworkService;
import com.perycreep.courierapppizzeria.network.auth_service.LoginRequest.LoginRequest;
import com.perycreep.courierapppizzeria.network.auth_service.LoginRequest.RegistrationRequest;
import com.perycreep.courierapppizzeria.ui.orders.OrderActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button RefistrationButton = binding.registration;

        RefistrationButton.setOnClickListener(view -> {
            String usernameText = binding.username.getText().toString();
            String emailText = binding.userEmail.getText().toString();
            String passwordText = binding.password.getText().toString();

            if(TextUtils.isEmpty(usernameText) || TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)){
                Toast.makeText(RegistrationActivity.this, "Заполните все поля",Toast.LENGTH_LONG).show();
            }
            else {
                NetworkService.getRestAdapter().authService.RegistrationUser(new RegistrationRequest(usernameText, passwordText, emailText)).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "Зарегистрировались ", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegistrationActivity.this, OrderActivity.class));
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this, "Вход запрещен",Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(RegistrationActivity.this, "Trowable " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void goToLoginActivity(View v){
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }
}