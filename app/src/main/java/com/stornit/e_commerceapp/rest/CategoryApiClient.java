package com.stornit.e_commerceapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryApiClient {

    public static final String CATEGORY_BASE_URL = "https://bketon.com/ecommerce/public/";
    private static Retrofit retrofit = null;

    public static Retrofit getCategoryClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(CATEGORY_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
