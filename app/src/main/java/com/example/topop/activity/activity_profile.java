package com.example.topop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_profile extends AppCompatActivity {

    public Button btnListBook, btnListMovie, btnListSerie;
    public ImageView imageViewLogout;
    private TextView textUsuarioProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        NomeUsuario();

        btnListBook = (Button) findViewById(R.id.btnListBooks);
        btnListMovie = (Button) findViewById(R.id.btnListMovies);
        btnListSerie = (Button) findViewById(R.id.btnListSeries);
        imageViewLogout = (ImageView) findViewById(R.id.logOut);

        btnListBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirListBooks();
            }
        });

        btnListMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirListMovies();
            }
        });

        btnListSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirListSeries();
            }
        });

        imageViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_profile.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.profile);

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
                        return true;
                }
                return false;
            }
        });
    }

    public void abrirListBooks(){
        Intent intent = new Intent(this, activity_list_books.class);
        startActivity(intent);
    }

    public void abrirListMovies(){
        Intent intent = new Intent(this, activity_list_movie.class);
        startActivity(intent);
    }

    public void abrirListSeries(){
        Intent intent = new Intent(this, activity_list_serie.class);
        startActivity(intent);
    }

    public void NomeUsuario(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        textUsuarioProfile = (TextView) findViewById(R.id.textUserName);
        textUsuarioProfile.setText(
                textUsuarioProfile.getText().toString() + user.getDisplayName()
        );
    }
}