package com.yono.androiddesignandstyle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.androiddesignandstyle.api.adapter.CategoryProductsAdapter;
import com.yono.androiddesignandstyle.api.models.MainViewModelCategory;
import com.yono.androiddesignandstyle.api.response.CategoryResponse;

import java.util.ArrayList;

public class EcommerceActivity extends AppCompatActivity {

    MainViewModelCategory mainViewModelCategory;
    RecyclerView recyclerView;
    CategoryProductsAdapter categoryProductsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_commerce);
        recyclerView = findViewById(R.id.rvCategory);

        mainViewModelCategory = ViewModelProviders.of(this).get(MainViewModelCategory.class);
        mainViewModelCategory.getCategoryList().observe(this, categoryListUpdate);
    }


    Observer<ArrayList<CategoryResponse>> categoryListUpdate = new Observer<ArrayList<CategoryResponse>>() {
        @Override
        public void onChanged(ArrayList<CategoryResponse> categoryResponses) {
            categoryProductsAdapter = new CategoryProductsAdapter(EcommerceActivity.this, categoryResponses);
            Log.d("Data Category", "Response "+categoryResponses);

            recyclerView.setLayoutManager(new GridLayoutManager(EcommerceActivity.this, 1));
            recyclerView.setAdapter(categoryProductsAdapter);
            categoryProductsAdapter.setOnItemClickCallback(this::showCategory);
        }

        private void showCategory(CategoryResponse categoryResponse) {
            Intent intent = new Intent(EcommerceActivity.this, EcommerceProducts.class);
            intent.putExtra("category", categoryResponse.getCategory());
            startActivity(intent);
        }
    };

}
