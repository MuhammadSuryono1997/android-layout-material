package com.yono.androiddesignandstyle.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.androiddesignandstyle.R;
import com.yono.androiddesignandstyle.api.response.CategoryResponse;
import com.yono.androiddesignandstyle.databinding.ItemCategoryProductBinding;
import com.yono.androiddesignandstyle.databinding.ItemProductsBinding;

import java.util.ArrayList;

public class CategoryProductsAdapter extends RecyclerView.Adapter<CategoryProductsAdapter.MyViewHolder> {

    private ArrayList<CategoryResponse> categoryResponseArrayList;
    Context context;

    public CategoryProductsAdapter(Context context, ArrayList<CategoryResponse> categoryResponses){
        this.context = context;
        this.categoryResponseArrayList = categoryResponses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryProductsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryProductBinding itemProductsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_category_product,
                parent,
                false
        );
        return new MyViewHolder(itemProductsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryProductsAdapter.MyViewHolder holder, int position) {
        holder.binData(categoryResponseArrayList.get(position));
        holder.itemCategoryProductBinding.getRoot().setOnClickListener(
                v -> onItemClickCallback.onItemClicked(categoryResponseArrayList.get(holder.getAdapterPosition()))
        );
    }

    private CategoryProductsAdapter.MyViewHolder.OnItemClickCallbackPost onItemClickCallback;
    public void setOnItemClickCallback(CategoryProductsAdapter.MyViewHolder.OnItemClickCallbackPost onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }




    @Override
    public int getItemCount() {
        return categoryResponseArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryProductBinding itemCategoryProductBinding;
        public MyViewHolder(@NonNull ItemCategoryProductBinding binding) {
            super(binding.getRoot());
            this.itemCategoryProductBinding = binding;
        }

        public void binData(CategoryResponse categoryResponse){
            itemCategoryProductBinding.setCategory(categoryResponse);
            itemCategoryProductBinding.setImages(categoryResponse.getImages());
        }

        public interface OnItemClickCallbackPost {
            void onItemClicked(CategoryResponse data);
        }

    }
}
