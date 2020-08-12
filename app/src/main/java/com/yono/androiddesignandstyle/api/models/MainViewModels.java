package com.yono.androiddesignandstyle.api.models;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.yono.androiddesignandstyle.api.ApiHelper;
import com.yono.androiddesignandstyle.api.client.Client;
import com.yono.androiddesignandstyle.api.response.ProductsResponse;
import com.yono.androiddesignandstyle.api.service.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModels extends ViewModel {

    MutableLiveData<ArrayList<ProductsResponse>> productsList;

    public MainViewModels(){
        productsList = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<ProductsResponse>> getProductsList(){
        getAllProduct();
        return productsList;
    }

    public MutableLiveData<ArrayList<ProductsResponse>> getProductsCategory(String category){
        getProductByCategory(category);
        return productsList;
    }

    private void getAllProduct() {
        Client client = new Client();
        Service service = client.Client(Service.class, ApiHelper.BASE_URL);

        service.getProducts().enqueue(new Callback<ArrayList<ProductsResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductsResponse>> call, Response<ArrayList<ProductsResponse>> response) {
                productsList.setValue(response.body());
                String sg = new Gson().toJson(response.body());
                Log.d("Data Posts", sg);
            }

            @Override
            public void onFailure(Call<ArrayList<ProductsResponse>> call, Throwable t) {
                Log.e("Error get data products", "Response : "+t.getMessage());
            }
        });
    }

    private void getProductByCategory(String category){
        Client client = new Client();
        Service service = client.Client(Service.class, ApiHelper.BASE_URL);

        service.getProductsbyCategory(category).enqueue(new Callback<ArrayList<ProductsResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductsResponse>> call, Response<ArrayList<ProductsResponse>> response) {
                productsList.setValue(response.body());
                String sg = new Gson().toJson(response.body());
                Log.d("Data Posts categpry", sg);
            }

            @Override
            public void onFailure(Call<ArrayList<ProductsResponse>> call, Throwable t) {
                Log.e("Error get data category", "Response : "+t.getMessage());
            }
        });
    }



}
