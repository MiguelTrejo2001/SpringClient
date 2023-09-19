package com.genuinecoder.springclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.genuinecoder.springclient.adapter.ProductoAdapter;
import com.genuinecoder.springclient.model.Producto;
import com.genuinecoder.springclient.reotrfit.ProductoApi;
import com.genuinecoder.springclient.reotrfit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoListActivity extends AppCompatActivity {

  private RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_employee_list);

    recyclerView = findViewById(R.id.employeeList_recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    FloatingActionButton floatingActionButton = findViewById(R.id.employeeList_fab);
    floatingActionButton.setOnClickListener(view -> {
      Intent intent = new Intent(this, ProductoForm.class);
      startActivity(intent);
    });
  }

  private void loadProducto() {
    RetrofitService retrofitService = new RetrofitService();
    ProductoApi productoApi = retrofitService.getRetrofit().create(ProductoApi.class);
    productoApi.getAllProductos()
        .enqueue(new Callback<List<Producto>>() {
          @Override
          public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
            populateListView(response.body());
          }

          @Override
          public void onFailure(Call<List<Producto>> call, Throwable t) {
            Toast.makeText(ProductoListActivity.this, "Failed to load employees", Toast.LENGTH_SHORT).show();
          }
        });
  }

  private void populateListView(List<Producto> productoList) {
    ProductoAdapter productoAdapter = new ProductoAdapter(productoList);
    recyclerView.setAdapter(productoAdapter);
  }

  @Override
  protected void onResume() {
    super.onResume();
    loadProducto();
  }
}