package com.example.examenprueba1.request;

import com.example.examenprueba1.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface gender_request {
    @GET("?results=50&gender={gender}")
    Call<Result> getResults(@Path("gender") String gender);
}
