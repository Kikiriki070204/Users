package com.example.examenprueba1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView message;

    private int pastVisibleItems, visibleItemCount, totalItemsCount;
    private boolean loading = true;
    private String gender = "default";
    private LinearLayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);
        female_filter = findViewById(R.id.females);
        male_filter = findViewById(R.id.males);
        reset = findViewById(R.id.reset);
        message = findViewById(R.id.message);


        UserAdapter userAdapter = new UserAdapter(new ArrayList<>(), this);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        result_viewmodel resultViewModel = viewModelProvider.get(result_viewmodel.class);
        myLayoutManager = new LinearLayoutManager(this);

        recycler.setAdapter(userAdapter);
        recycler.setLayoutManager(myLayoutManager);
        recycler.setHasFixedSize(true);

        List <UserModel> totalUsuarios = new ArrayList<>();

        resultViewModel.results(50);

        female_filter.setOnClickListener(v -> {
            gender = "female";
            totalUsuarios.clear();
            userAdapter.update(new ArrayList<>());
            resultViewModel.resultsByGender(50,"female");
        });
        male_filter.setOnClickListener(v -> {
            gender = "male";
            totalUsuarios.clear();
            userAdapter.update(new ArrayList<>());
            resultViewModel.resultsByGender(50,"male");
        });
        reset.setOnClickListener(v -> {
            gender = "default";
            totalUsuarios.clear();
            userAdapter.update(new ArrayList<>());
            resultViewModel.results(50);
        });


        resultViewModel.getUsers().observe(this, result -> {
            if (result != null ) {
                totalUsuarios.addAll(result.getResults());
                userAdapter.update(totalUsuarios);
                message.setVisibility(View.GONE);
                loading = true;
            }
            else
            {

                message.setText("No se encontraron resultados.");
                message.setVisibility(View.VISIBLE);

            }
        });

        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0 )
                {
                    visibleItemCount = myLayoutManager.getChildCount();
                    totalItemsCount = myLayoutManager.getItemCount();
                    pastVisibleItems = myLayoutManager.findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemsCount)
                        {
                            loading = false;
                            Toast.makeText(MainActivity.this, "Haz llegado al final, cargando...", Toast.LENGTH_SHORT).show();
                            if(gender.equals("default"))
                            {
                                resultViewModel.results(10);

                                Log.d("CANTIDAD", "Total items: " + totalItemsCount);

                            }
                            else
                            {
                                resultViewModel.resultsByGender(10, gender);

                                Log.d("CANTIDAD POR GENERO", "Total items: " + totalItemsCount);

                            }
                        }
                    }
                }
            }

        });

    }

    @Override
    public void OnClick(UserModel user) {
        String street  = user.getLocation().getStreet().str() + ", " + user.getLocation().getCity();
        String city = user.getLocation().getCity().toString();
        String stct = user.getLocation().getState() + ", " + user.getLocation().getCountry();
        String phone  = user.getPhone().toString();
        String picture  =user.getPicture().getLarge();
        String latitude  =user.getLocation().getCoordinates().getLatitude().toString();
        String longitude = user.getLocation().getCoordinates().getLongitude().toString();


        Intent data = new Intent(getApplicationContext(), UserData.class);

        data.putExtra("street", street);
        data.putExtra("stct", stct);
        data.putExtra("phone", phone);
        data.putExtra("picture", picture);
        data.putExtra("latitude", latitude);
        data.putExtra("longitude", longitude);
        data.putExtra("city", city);
        startActivity(data);
    }
}