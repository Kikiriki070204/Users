package com.example.examenprueba1.model_views;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenprueba1.models.UserModel;
import com.example.examenprueba1.repository.UserRepo;

public class user_viewmodel extends ViewModel {
    private MutableLiveData<UserModel> model;
    private UserRepo userRepo;
    public LiveData<UserModel> getUser()
    {
        if(model==null)
        {
            model=new MutableLiveData<>();
        }
        return model;
    }


}
