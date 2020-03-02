package com.stornit.e_commerceapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("categoryList")
    private List<Category> categoryList;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("totalPages")
    private int totalPages;








}
