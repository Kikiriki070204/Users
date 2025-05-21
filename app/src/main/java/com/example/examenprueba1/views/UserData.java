package com.example.examenprueba1.views;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenprueba1.R;

public class UserData extends AppCompatActivity {
    TextView street, state, phone, error_username, error_password;
    ImageView img, back;
    String picture, username_data, password_data;
    EditText username, password;
    Button verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        street = findViewById(R.id.street);
        state = findViewById(R.id.stct);
        phone = findViewById(R.id.phone);
        img  = findViewById(R.id.image);
        back = findViewById(R.id.back);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        verify = findViewById(R.id.verify);
        error_username = findViewById(R.id.error_username);
        error_password = findViewById(R.id.error_password);

        Intent i = getIntent();
        street.setText(i.getStringExtra("street"));
        state.setText(i.getStringExtra("stct"));
        phone.setText(i.getStringExtra("phone"));
        picture = i.getStringExtra("picture");
        username_data = i.getStringExtra("username");
        password_data = i.getStringExtra("password");

        username.setText(username_data);
        password.setText(password_data);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String entered_username = username.getText().toString();
            String entered_password = password.getText().toString();

            error_username.setVisibility(View.GONE);
            error_password.setVisibility(View.GONE);

            if (entered_username.isEmpty()) {
            error_username.setVisibility(View.VISIBLE);
            }
            if (entered_password.isEmpty()) {
            error_password.setVisibility(View.VISIBLE);
            }

            if(entered_username.equals(username_data) && entered_password.equals(password_data))
            {
                Toast.makeText(UserData.this,"¡Verificación exitosa!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(UserData.this,"¡Error! Los datos de verificación no coinciden", Toast.LENGTH_SHORT).show();

            }

            }
        });


        Glide.with(this).load(picture).into(img);

    }
}