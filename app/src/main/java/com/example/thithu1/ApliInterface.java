package com.example.thithu1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApliInterface {
    @GET("getall.json")
    Call<ListProduct> getJson();



}
