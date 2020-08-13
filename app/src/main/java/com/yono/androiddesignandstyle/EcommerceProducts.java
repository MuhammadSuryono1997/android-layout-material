package com.yono.androiddesignandstyle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.androiddesignandstyle.api.adapter.ProductsAdapter;
import com.yono.androiddesignandstyle.api.models.MainViewModels;
import com.yono.androiddesignandstyle.api.response.CategoryResponse;
import com.yono.androiddesignandstyle.api.response.ProductsResponse;

import java.util.ArrayList;

public class EcommerceProducts extends AppCompatActivity {
    TextView judulCategory;
    ProgressBar pbLoading;
    MainViewModels viewModels;
    ProductsAdapter productsAdapter;
    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_commerce_products);
        judulCategory = findViewById(R.id.judul_category);
        recyclerView = findViewById(R.id.rvProductsCategory);
        pbLoading = findViewById(R.id.pbLoading);

        showLoading(true);
        Intent intent = getIntent();
        judulCategory.setText(intent.getStringExtra("category").toUpperCase());

        viewModels = ViewModelProviders.of(this).get(MainViewModels.class);
        viewModels.getProductsCategory(intent.getStringExtra("category").toLowerCase()).observe(this, productsUpdateObserve);

    }

    Observer<ArrayList<ProductsResponse>> productsUpdateObserve = new Observer<ArrayList<ProductsResponse>>() {
        @Override
        public void onChanged(ArrayList<ProductsResponse> productsResponses) {
            productsAdapter = new ProductsAdapter();

            Log.d("Get products", "Response : "+productsResponses);
            productsAdapter.setProductsResponseArrayList(EcommerceProducts.this, productsResponses);
            recyclerView.setLayoutManager(new GridLayoutManager(EcommerceProducts.this, 2));
            recyclerView.setAdapter(productsAdapter);
            showLoading(false);
            productsAdapter.setOnItemClickCallback(this::showCategory);
        }


        private void showCategory(ProductsResponse productsResponse) {
            Intent intent = new Intent(EcommerceProducts.this, EcommerceDetail.class);
            intent.putExtra("title_detail", productsResponse.getTitleProducts());
            intent.putExtra("price_detail", productsResponse.getPriceProducts());
            intent.putExtra("description_detail", productsResponse.getDescriptionProducts());
            startActivity(intent);
        }
    };

    public void showLoading(boolean isLoading) {
        if (isLoading) {
            pbLoading.setVisibility(View.VISIBLE);
        } else {
            pbLoading.setVisibility(View.GONE);
        }
    }
}
