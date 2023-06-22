package com.perycreep.courierapppizzeria.ui.orders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.perycreep.courierapppizzeria.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {

    TextView numOrder, addressOrder;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        numOrder = itemView.findViewById(R.id.numOrder);
        addressOrder = itemView.findViewById(R.id.addressOrder);

    }
}
