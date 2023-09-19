package com.genuinecoder.springclient;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.genuinecoder.springclient.model.Producto;
import com.genuinecoder.springclient.reotrfit.ProductoApi;
import com.genuinecoder.springclient.reotrfit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoForm extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initializeComponents();
  }

  private void initializeComponents() {
    TextInputEditText inputEditTextName = findViewById(R.id.form_textFieldName);
    TextInputEditText inputEditBranch = findViewById(R.id.form_textFieldBranch);
    TextInputEditText inputEditLocation = findViewById(R.id.form_textFieldLocation);
    MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

    RetrofitService retrofitService = new RetrofitService();
    ProductoApi productoApi = retrofitService.getRetrofit().create(ProductoApi.class);

    buttonSave.setOnClickListener(view -> {
      String nombre = String.valueOf(inputEditTextName.getText());
      String precio = String.valueOf(inputEditBranch.getText());
      String stock = String.valueOf(inputEditLocation.getText());

      Producto producto = new Producto();
      producto.setNombre(nombre);
      producto.setPrecio(precio);
      producto.setStock(stock);

      productoApi.save(producto)
          .enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
              Toast.makeText(ProductoForm.this, "Save successful!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
              Toast.makeText(ProductoForm.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
              Logger.getLogger(ProductoForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
            }
          });
    });
  }
}