package com.example.examenprueba1.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenprueba1.models.Result;
import com.example.examenprueba1.repository.ResultRepo;

public class result_viewmodel extends ViewModel {
    private MutableLiveData<Result> resultModel = new MutableLiveData<>();
    private ResultRepo resultRepo = new ResultRepo();


         public LiveData<Result> getUsers() {
                return resultModel;
         }
        public void results(Integer results) {
        resultRepo.getResults(results, null).observeForever(result -> {
        resultModel.setValue(result);
        });
        }

        public void resultsByGender(Integer results, String gender){
            resultRepo.getResults(results,gender).observeForever(result -> {
                resultModel.setValue(result);
            });
        }
}