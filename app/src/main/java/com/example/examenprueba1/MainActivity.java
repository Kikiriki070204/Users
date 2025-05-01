package com.example.examenprueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examenprueba1.models.UserModel;
import com.example.examenprueba1.model_views.user_viewmodel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);

        List<UserModel> userList=new ArrayList<>();

        ViewModelProvider viewModel=new ViewModelProvider(this);
        user_viewmodel userViewModel=viewModel.get(user_viewmodel.class);
        userViewModel.getUser().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                if(userModel != null)
                {

                }
            }
        });



    }

}