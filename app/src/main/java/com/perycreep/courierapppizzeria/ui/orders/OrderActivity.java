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
        items.add(new OrderItem(45343, "Bibl 45"));
        items.add(new OrderItem(43524, "8 Marta 62"));
        items.add(new OrderItem(76587, "Mira 32"));
        items.add(new OrderItem(5754, "Ermaka 35"));
        items.add(new OrderItem(97695, "Kosmonavtov 34"));


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OrderAdapter(getApplicationContext(),items));
    }
}
