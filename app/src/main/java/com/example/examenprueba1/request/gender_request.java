package com.example.examenprueba1.request;

import com.example.examenprueba1.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface gender_request {
    @GET("/api/")
    Call<Result> getResults(@Query("results") int result, @Query("gender") String gender);
}
