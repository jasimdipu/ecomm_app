package com.stornit.e_commerceapp.models;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("category_name")
    private String category_name;
    @SerializedName("photo")
    private String photo;

    public Category(String category_name, String photo) {
        this.category_name = category_name;
        this.photo = photo;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_name='" + category_name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
