package com.example.examenprueba1.request;

import com.example.examenprueba1.models.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface users_request {
    @GET("?results=50")
    Call <UserModel> getData();

}
