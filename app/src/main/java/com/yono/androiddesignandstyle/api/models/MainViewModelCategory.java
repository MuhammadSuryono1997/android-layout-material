package com.yono.androiddesignandstyle.api.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yono.androiddesignandstyle.api.response.CategoryResponse;
import com.yono.androiddesignandstyle.api.response.ProductsResponse;

import java.util.ArrayList;

public class MainViewModelCategory extends ViewModel {
    MutableLiveData<ArrayList<CategoryResponse>> categoryResponse;
    private ArrayList<CategoryResponse> categoryResponseArrayList;

    public MainViewModelCategory(){
        categoryResponse = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<CategoryResponse>> getCategoryList(){
        return categoryResponse;
    }

    private void init() {
        categoryResponseArrayList = new ArrayList<>();
        categoryResponseArrayList.add(
                new CategoryResponse("men clothing",
                "https://i.pinimg.com/originals/8b/42/03/8b4203bc89605c3348eed9e15f89e574.jpg"));
        categoryResponseArrayList.add(
                new CategoryResponse("jewelery",
                        "https://image.freepik.com/free-photo/ripple-ornament-forever-drop-costume_1232-3547.jpg"));
        categoryResponseArrayList.add(
                new CategoryResponse("electronics",
                        "https://static.republika.co.id/uploads/images/inpicture_slide/international-consumer-electronics-show-ces-di-las-vegas_200729131322-539.jpg"));
        categoryResponseArrayList.add(
                new CategoryResponse("women clothing",
                        "https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg"));

        categoryResponse.setValue(categoryResponseArrayList);

    }
}
