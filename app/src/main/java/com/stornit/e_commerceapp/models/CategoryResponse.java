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


    public int getPage(){
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
