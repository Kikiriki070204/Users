package com.example.examenprueba1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.examenprueba1.R;

public class UserData extends AppCompatActivity {
    TextView street, state, phone;
    String picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        street = findViewById(R.id.street);
        state = findViewById(R.id.stct);
        phone = findViewById(R.id.phone);

        Intent i = getIntent();
        street.setText(i.getStringExtra("street"));
        state.setText(i.getStringExtra("stct"));
        phone.setText(i.getStringExtra("phone"));
        picture = i.getStringExtra("picture");
    }
}