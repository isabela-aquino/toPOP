package com.example.topop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.example.topop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class activity_book_details extends AppCompatActivity {

    private ImageView btnVoltarBookDetails;

    String title, description, thumbnail;
    private ArrayList<String> authors;


    TextView titleTV, descTV, authorTV;

    ImageView bookIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        // initializing our views..
        titleTV = findViewById(R.id.titleBook);
        descTV = findViewById(R.id.descriptionBook);
        //authorTV = findViewById(R.id.autoraLivro);
        bookIV = findViewById(R.id.imageBook);


        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        //authors = getIntent().getStringArrayListExtra("authors");
        thumbnail = getIntent().getStringExtra("thumbnail");


        titleTV.setText(title);
        descTV.setText(description);
        //authorTV.setText((CharSequence) authors);
        Picasso.get().load(thumbnail).into(bookIV);

        btnVoltarBookDetails = (ImageView) findViewById(R.id.voltarBookDetails);

        btnVoltarBookDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_book_details.this, activity_list_books.class);
                startActivity(intent);
            }
        });

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), activity_pagina_inicial.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), activity_search.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), activity_profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }
}