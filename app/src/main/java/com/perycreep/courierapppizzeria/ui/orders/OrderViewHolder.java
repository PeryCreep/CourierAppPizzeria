package com.perycreep.courierapppizzeria.ui.orders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.perycreep.courierapppizzeria.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {

    TextView totalOrder, addressOrder, totalSumm;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        totalOrder = itemView.findViewById(R.id.totalOrder);
        addressOrder = itemView.findViewById(R.id.addressOrder);
        totalSumm = itemView.findViewById(R.id.totalSumm);
    }
}
