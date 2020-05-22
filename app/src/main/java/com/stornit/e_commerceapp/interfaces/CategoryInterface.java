package com.stornit.e_commerceapp.interfaces;

import com.stornit.e_commerceapp.models.Category;
import com.stornit.e_commerceapp.models.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryInterface {
    @GET("api/categories")
    Call<CategoryResponse> getCategories(@Query("url") String URL);
}
