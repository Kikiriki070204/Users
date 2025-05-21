package com.example.examenprueba1.views;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examenprueba1.R;

public class UserData extends AppCompatActivity {
    TextView street, state, phone;
    ImageView img, back;
    String picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        street = findViewById(R.id.street);
        state = findViewById(R.id.stct);
        phone = findViewById(R.id.phone);
        img  = findViewById(R.id.image);
        ubicacion = findViewById(R.id.ubicacion);





        Intent i = getIntent();
        street.setText(i.getStringExtra("street"));
        state.setText(i.getStringExtra("stct"));
        phone.setText(i.getStringExtra("phone"));
        picture = i.getStringExtra("picture");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String query = street.getText().toString();
                Log.d("query: ", query);
            Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + Uri.encode(query));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        Glide.with(this).load(picture).into(img);

    }
}