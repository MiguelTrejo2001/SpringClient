package com.genuinecoder.springclient.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.genuinecoder.springclient.R;

public class ProductoHolder extends RecyclerView.ViewHolder {

    TextView Nombre, Precio, Stock;

    public ProductoHolder(@NonNull View itemView) {
        super(itemView);
        Nombre = itemView.findViewById(R.id.nombre);
        Precio = itemView.findViewById(R.id.precio);
        Stock = itemView.findViewById(R.id.stock);
    }
}
