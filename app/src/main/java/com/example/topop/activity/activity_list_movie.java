package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.topop.R;
import com.example.topop.fragments.EstouLendoBooksFragment;
import com.example.topop.fragments.JaAssistiMoviesFragment;
import com.example.topop.fragments.JaLiBooksFragment;
import com.example.topop.fragments.QueroAssistirMoviesFragment;
import com.example.topop.fragments.QueroLerBooksFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class activity_list_movie extends AppCompatActivity {

    private TabLayout tabLayoutMovie;

    private JaAssistiMoviesFragment jaAssistiMoviesFragment;
    private QueroAssistirMoviesFragment queroAssistirMoviesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        tabLayoutMovie = (TabLayout) findViewById(R.id.TabLayoutMovie);

        jaAssistiMoviesFragment = new JaAssistiMoviesFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameMovies, jaAssistiMoviesFragment);
        transaction.commit();

        tabLayoutMovie.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameMovies, jaAssistiMoviesFragment);
                        transaction.commit();
                        break;
                    case 1:
                        queroAssistirMoviesFragment = new QueroAssistirMoviesFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameMovies, queroAssistirMoviesFragment);
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