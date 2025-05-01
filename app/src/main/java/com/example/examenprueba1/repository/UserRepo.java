package com.example.examenprueba1.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.examenprueba1.models.UserModel;
import com.example.examenprueba1.retrofit.request;
import com.example.examenprueba1.request.users_request;

public class UserRepo {
    public Retrofit retrofit;
    void setRetrofit(){retrofit=request.getRetrofit();}

    public MutableLiveData<UserModel> newUser(String gender, UserModel.Name name, UserModel.Location location, String email,
                                              UserModel.Picture picture,String phone)
    {
        setRetrofit();
        users_request UserRequest=retrofit.create(users_request.class);
        Call<UserModel> userModelCall= UserRequest.getData();
        MutableLiveData<UserModel> mutable=new MutableLiveData<>();
        Log.d("users", "hello <}):0){");

        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.d("Usuario", ":-)");
                UserModel userModel;

                userModel= new UserModel();
                mutable.setValue(userModel);
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
        return mutable;

    }
}
