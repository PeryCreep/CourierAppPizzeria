package com.perycreep.courierapppizzeria.ui.orders;

import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.perycreep.courierapppizzeria.R;
import com.perycreep.courierapppizzeria.databinding.ActivityLoginBinding;
import com.perycreep.courierapppizzeria.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private ActivityOrderBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem("Разумов Алексей Антонович", "Bibl 45", 1400d, true, "Pepperoni"));
        items.add(new OrderItem("Polyakov Artem", "Mira 20", 2200d, true, "4 cheese"));
        items.add(new OrderItem("Pupkin Vasya", "Ermaka 35", 800d, true, "Stolovskaya"));



        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OrderAdapter(getApplicationContext(),items));
    }
}
