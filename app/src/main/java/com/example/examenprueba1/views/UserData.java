package com.example.examenprueba1.views;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.examenprueba1.R;

public class UserData extends AppCompatActivity {
    TextView street, state, phone;
    ImageView img, back;
    String picture, mensaje;

    LinearLayout contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        street = findViewById(R.id.street);
        state = findViewById(R.id.stct);
        phone = findViewById(R.id.phone);
        img  = findViewById(R.id.image);
        back = findViewById(R.id.back);
        contacto = findViewById(R.id.contact);


        Intent i = getIntent();
        street.setText(i.getStringExtra("street"));
        state.setText(i.getStringExtra("stct"));
        phone.setText(i.getStringExtra("phone"));
        picture = i.getStringExtra("picture");
        mensaje = i.getStringExtra("mensaje");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(intent);
                }
            }
        });

        Glide.with(this).load(picture).into(img);

    }
}