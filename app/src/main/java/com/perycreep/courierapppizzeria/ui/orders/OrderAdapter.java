package com.perycreep.courierapppizzeria.ui.orders;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.perycreep.courierapppizzeria.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {

    Context context;
    List<OrderItem> items;

    public OrderAdapter(Context context, List<OrderItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.numOrder.setText("Заказ №" + items.get(position).getNumder());
        holder.addressOrder.setText(items.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
