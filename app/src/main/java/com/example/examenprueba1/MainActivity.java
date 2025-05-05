package com.example.examenprueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.examenprueba1.adapters.UserAdapter;
import com.example.examenprueba1.listeners.UserListener;
import com.example.examenprueba1.models.Result;
import com.example.examenprueba1.models.UserModel;
import com.example.examenprueba1.viewmodels.result_viewmodel;
import com.example.examenprueba1.views.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserListener {
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        result_viewmodel resultViewModel = viewModelProvider.get(result_viewmodel.class);

        resultViewModel.getUsers().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if (result != null)
                {
                    recycler.setAdapter(new UserAdapter(result.results,MainActivity.this ));
                    recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recycler.setHasFixedSize(true);
                }
            }
        });


    }

    @Override
    public void OnClick(UserModel user) {
        String street  = user.getLocation().getStreet().str() + ", " + user.getLocation().getCity();
        String stct = user.getLocation().getState() + ", " + user.getLocation().getCountry();
        String phone  = user.getPhone().toString();
        String picture  =user.getPicture().getThumbnail();

        Intent data = new Intent(getApplicationContext(), UserData.class);
        data.putExtra("street", street);
        data.putExtra("stct", stct);
        data.putExtra("phone", phone);
        data.putExtra("picture", picture);
        startActivity(data);
    }
}