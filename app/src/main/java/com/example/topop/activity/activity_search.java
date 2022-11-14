package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.topop.R;
import com.example.topop.fragments.SearchBookFragment;
import com.example.topop.fragments.SearchMovieFragment;
import com.example.topop.fragments.SearchSerieFragment;
import com.google.android.material.tabs.TabItem;

public class activity_search extends AppCompatActivity {

    private TabItem tabISeries, tabIMovies, tabIBooks;

    private SearchBookFragment searchBookFragment;
    private SearchMovieFragment searchMovieFragment;
    private SearchSerieFragment searchSerieFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tabIBooks = findViewById(R.id.tablJaLi);
        tabIMovies = findViewById(R.id.tablQueroLer);
        tabISeries = findViewById(R.id.tabIEstouLendo);

        searchBookFragment = new SearchBookFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameBooks, searchBookFragment);
        transaction.commit();

        tabIBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameBooks, searchBookFragment);
                transaction.commit();
            }
        });

        tabIMovies.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchMovieFragment = new SearchMovieFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameBooks, searchMovieFragment);
                transaction.commit();
            }
        }));

        tabISeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchSerieFragment = new SearchSerieFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameBooks, searchSerieFragment);
                transaction.commit();
            }
        });
    }
}