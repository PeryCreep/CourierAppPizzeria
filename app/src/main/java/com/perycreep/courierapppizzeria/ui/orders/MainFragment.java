package com.perycreep.courierapppizzeria.ui.orders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.perycreep.courierapppizzeria.R;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {

    View view;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem("Разумов Алексей Антонович", "Bibl 45", 1400d, true, "Pepperoni"));
        items.add(new OrderItem("Polyakov Artem", "Mira 20", 2200d, true, "4 cheese"));
        items.add(new OrderItem("Pupkin Vasya", "Ermaka 35", 800d, true, "Stolovskaya"));
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        OrderAdapter orderAdapter = new OrderAdapter(getContext(), items);
        recyclerView.setAdapter(orderAdapter);
        orderAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }


}