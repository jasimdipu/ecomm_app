package com.stornit.e_commerceapp.models;

public class Category {

    int CategoryId;
    String CategoryName;
    int CategoryImg;

    public Category(int categoryId, String categoryName, int categoryImg) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        CategoryImg = categoryImg;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getCategoryImg() {
        return CategoryImg;
    }

    public void setCategoryImg(int categoryImg) {
        CategoryImg = categoryImg;
    }
}