package com.example.examenprueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

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
    Button female_filter, male_filter, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);
        female_filter = findViewById(R.id.females);
        male_filter = findViewById(R.id.males);
        reset = findViewById(R.id.reset);


        UserAdapter userAdapter = new UserAdapter(new ArrayList<>(), this);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        result_viewmodel resultViewModel = viewModelProvider.get(result_viewmodel.class);

        recycler.setAdapter(userAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        resultViewModel.results();

        female_filter.setOnClickListener(v -> {
            resultViewModel.resultsByGender("female");
        });
        male_filter.setOnClickListener(v -> {
            resultViewModel.resultsByGender("male");
        });
        reset.setOnClickListener(v -> {
            resultViewModel.results();
        });


        resultViewModel.getUsers().observe(this, result -> {
            if (result != null ) {
                userAdapter.update(result.getResults());
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