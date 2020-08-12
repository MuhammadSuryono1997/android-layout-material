package com.yono.androiddesignandstyle.api.service;

import com.yono.androiddesignandstyle.api.response.ProductsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("products")
    Call<ArrayList<ProductsResponse>> getProducts();

    @GET("products/category/{category}")
    Call<ArrayList<ProductsResponse>> getProductsbyCategory(@Path("category") String category);
}
