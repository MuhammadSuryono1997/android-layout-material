package com.yono.androiddesignandstyle;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.yono.androiddesignandstyle.api.response.ProductsResponse;
import com.yono.androiddesignandstyle.databinding.ECommerceDetailBinding;

import java.util.ArrayList;

public class EcommerceDetail extends AppCompatActivity {

    ECommerceDetailBinding eCommerceDetailBinding;
    ArrayList<ProductsResponse> productsResponses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_commerce_detail);
//        eCommerceDetailBinding = DataBindingUtil.setContentView(this, R.layout.e_commerce_detail);
//        Intent intent = getIntent();
    }
}
