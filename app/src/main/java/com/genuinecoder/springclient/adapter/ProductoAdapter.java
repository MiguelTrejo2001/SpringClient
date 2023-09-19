package com.genuinecoder.springclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.genuinecoder.springclient.R;
import com.genuinecoder.springclient.model.Producto;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoHolder> {
    private List<Producto> productoList;

    public ProductoAdapter(List<Producto> productoList){
        this.productoList = productoList;
    }

    @NonNull
    @Override
    public ProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_employee_item,parent, false);
        return new ProductoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoHolder holder, int position){
        Producto producto = productoList.get(position);
        holder.Nombre.setText(producto.getNombre());
        holder.Precio.setText(producto.getPrecio());
        holder.Stock.setText(producto.getStock());
    }

    @Override
    public int getItemCount(){
        return  productoList.size();
    }
}
