package com.example.examenprueba1.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenprueba1.models.Result;
import com.example.examenprueba1.repository.ResultRepo;

public class result_viewmodel extends ViewModel {
    private MutableLiveData<Result> resultModel;
    private ResultRepo resultRepo;

    public LiveData<Result> getUsers()
    {
        if (resultModel == null)
        {
            resultModel=new MutableLiveData<>();
            results();
        }
        return resultModel;
    }

    private void results()
    {
        if(resultRepo == null)
        {
            resultRepo=new ResultRepo();
        }
        resultModel = resultRepo.getResults();
    }
}
