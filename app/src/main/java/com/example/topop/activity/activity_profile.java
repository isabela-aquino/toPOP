package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topop.R;

public class activity_profile extends AppCompatActivity {

    public Button btnListBook, btnListMovie, btnListSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnListBook = (Button) findViewById(R.id.btnListBooks);
        btnListMovie = (Button) findViewById(R.id.btnListMovies);
        btnListSerie = (Button) findViewById(R.id.btnListSeries);

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
}