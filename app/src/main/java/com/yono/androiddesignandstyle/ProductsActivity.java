package com.yono.androiddesignandstyle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.androiddesignandstyle.api.adapter.ProductsAdapter;
import com.yono.androiddesignandstyle.api.models.MainViewModels;
import com.yono.androiddesignandstyle.api.response.ProductsResponse;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    MainViewModels viewModels;
    ProductsAdapter productsAdapter;
    RecyclerView recyclerView;
    ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_shrine);
        recyclerView = findViewById(R.id.rvProducts);
        pbLoading = findViewById(R.id.pbLoading);

        showLoading(true);

        viewModels = ViewModelProviders.of(this).get(MainViewModels.class);
        viewModels.getProductsList().observe(this, productsUpdateObserve);

    }

    Observer<ArrayList<ProductsResponse>> productsUpdateObserve = new Observer<ArrayList<ProductsResponse>>() {
        @Override
        public void onChanged(ArrayList<ProductsResponse> productsResponses) {
            productsAdapter = new ProductsAdapter();

            Log.d("Get data success", "Response : "+productsResponses);
            productsAdapter.setProductsResponseArrayList(ProductsActivity.this, productsResponses);
            recyclerView.setLayoutManager(new GridLayoutManager(ProductsActivity.this, 2));
            recyclerView.setAdapter(productsAdapter);
            showLoading(false);
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
