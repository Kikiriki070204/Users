package com.example.examenprueba1.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.examenprueba1.models.Result;
import com.example.examenprueba1.retrofit.request;
import com.example.examenprueba1.request.users_request;
import com.example.examenprueba1.request.gender_request;

public class ResultRepo {
public Retrofit retrofit;
void setRetrofit(){retrofit=request.getRetrofit();}

    public MutableLiveData<Result> getResults(String gender)
    {
        setRetrofit();
        Call<Result> resultCall;

        if(gender != null)
        {
            gender_request usersRequest  = retrofit.create(gender_request.class);
            resultCall = usersRequest.getResults(50, gender);
        }
        else
        {
            users_request usersRequest  = retrofit.create(users_request.class);
            resultCall = usersRequest.getResults();
        }


        MutableLiveData<Result> mutable = new MutableLiveData<>();
        Log.d("Retrofit URL", resultCall.request().url().toString());
        Log.d("MUTABLE","Escuchando el request");

        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.d("Usuarios..","Aquí hay usuarios");
                mutable.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("NULO..","Aquí NO hay usuarios");
                mutable.setValue(null);
            }
        });

        return mutable;
    }

}
