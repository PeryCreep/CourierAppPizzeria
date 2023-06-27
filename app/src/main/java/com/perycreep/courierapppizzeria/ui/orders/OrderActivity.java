package com.perycreep.courierapppizzeria.ui.orders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.perycreep.courierapppizzeria.R;
import com.perycreep.courierapppizzeria.databinding.ActivityLoginBinding;
import com.perycreep.courierapppizzeria.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private ActivityOrderBinding binding;
    ImageButton btnHistory, btnActive, btnProfile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_order);

        btnHistory = findViewById(R.id.btnHistory);
        btnActive = findViewById(R.id.btnActive);
        btnProfile = findViewById(R.id.btnProfile);

        btnHistory.setOnClickListener(view -> replaceFragment( new MainFragment()));
        btnActive.setOnClickListener(view -> replaceFragment( new BlankFragment()));
        btnProfile.setOnClickListener(view -> replaceFragment( new ProfileFragment()));

//        binding = ActivityOrderBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
