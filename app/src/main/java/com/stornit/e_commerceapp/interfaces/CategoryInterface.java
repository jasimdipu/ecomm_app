package com.stornit.e_commerceapp.interfaces;

import com.stornit.e_commerceapp.models.Category;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryInterface {
@GET("api/categories")
    Call<Category> getCategories(@Query("url") String URL);
}
