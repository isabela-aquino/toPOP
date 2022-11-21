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
import com.google.android.material.tabs.TabLayout;

public class activity_search extends AppCompatActivity {



    private TabLayout tabLayout;

    private SearchBookFragment searchBookFragment;
    private SearchMovieFragment searchMovieFragment;
    private SearchSerieFragment searchSerieFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        tabLayout = (TabLayout) findViewById(R.id.TabLayoutSearch);

        searchBookFragment = new SearchBookFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudoBooks, searchBookFragment);
        transaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        searchBookFragment = new SearchBookFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameConteudoBooks, searchBookFragment);
                        transaction.commit();
                        break;
                    case 1:
                        searchMovieFragment = new SearchMovieFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameConteudoBooks, searchMovieFragment);
                        transaction.commit();
                        break;
                    case 2:
                        searchSerieFragment = new SearchSerieFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameConteudoBooks, searchSerieFragment);
                        transaction.commit();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}