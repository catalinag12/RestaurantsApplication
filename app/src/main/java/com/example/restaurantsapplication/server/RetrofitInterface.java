package com.example.restaurantsapplication.server;

import com.example.restaurantsapplication.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("restaurant/list")
    Call<List<Item>> getRestaurants();
}
