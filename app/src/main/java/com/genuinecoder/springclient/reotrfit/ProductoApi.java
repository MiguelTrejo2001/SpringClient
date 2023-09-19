package com.genuinecoder.springclient.reotrfit;

import com.genuinecoder.springclient.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductoApi {

    @GET("/producto/get-all")
    Call<List<Producto>> getAllProductos();

    @POST("/producto/save")
    Call<Producto> save(@Body Producto producto);
}
