package com.yono.androiddesignandstyle.api.response;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class ProductsResponse {
    @SerializedName("title")
    private String titleProducts;

    @SerializedName("price")
    private float priceProducts;

    @SerializedName("image")
    private String imageProducts;

    @SerializedName("description")
    private String descriptionProducts;

    public String getTitleProducts() {
        return titleProducts;
    }

    public void setTitleProducts(String titleProducts) {
        this.titleProducts = titleProducts;
    }

    public float getPriceProducts() {
        return priceProducts;
    }

    public void setPriceProducts(float priceProducts) {
        this.priceProducts = priceProducts;
    }

    public String getImageProducts() {
        return imageProducts;
    }

    public void setImageProducts(String imageProducts) {
        this.imageProducts = imageProducts;
    }

    public String getDescriptionProducts() {
        return descriptionProducts;
    }

    public void setDescriptionProducts(String descriptionProducts) {
        this.descriptionProducts = descriptionProducts;
    }

    @BindingAdapter("imageProducts")
    public static void loadImage(ImageView view, String imageProducts){
        Glide.with(view.getContext()).load(imageProducts).apply(RequestOptions.centerInsideTransform()).into(view);
    }
}
