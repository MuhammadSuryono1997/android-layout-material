package com.yono.androiddesignandstyle.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yono.androiddesignandstyle.R;
import com.yono.androiddesignandstyle.api.response.ProductsResponse;
import com.yono.androiddesignandstyle.databinding.ItemProductsBinding;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    Context context;
    private ArrayList<ProductsResponse> productsResponseArrayList = new ArrayList<>();

    public void setProductsResponseArrayList(Context context, final ArrayList<ProductsResponse> productsResponseArrayList){
        this.context = context;
        this.productsResponseArrayList = productsResponseArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_products,
                parent,
                false
        );

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.MyViewHolder holder, int position) {
        holder.binData(productsResponseArrayList.get(position));
        holder.itemProductsBinding.getRoot().setOnClickListener(
                v -> onItemClickCallback.onItemClicked(productsResponseArrayList.get(holder.getAdapterPosition()))
        );
    }

    private ProductsAdapter.OnItemClickCallbackPost onItemClickCallback;
    public void setOnItemClickCallback(ProductsAdapter.OnItemClickCallbackPost onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public int getItemCount() {
        return productsResponseArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemProductsBinding itemProductsBinding;

        public MyViewHolder(@NonNull ItemProductsBinding binding) {
            super(binding.getRoot());
            this.itemProductsBinding = binding;
        }

        public void binData(ProductsResponse productsResponse){
            itemProductsBinding.setProducts(productsResponse);
            itemProductsBinding.setImage(productsResponse.getImageProducts());
        }
    }

    public interface OnItemClickCallbackPost {
        void onItemClicked(ProductsResponse data);
    }
}
