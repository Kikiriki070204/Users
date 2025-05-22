package com.example.examenprueba1.request;

import com.example.examenprueba1.models.Result;
import com.example.examenprueba1.models.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface users_request {
    @GET("/api/")
    Call<Result> getResults(@Query("results") int result);
}
