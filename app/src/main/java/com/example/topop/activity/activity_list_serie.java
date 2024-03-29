package com.example.topop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.topop.R;
import com.example.topop.fragments.EstouAssistindoSeriesFragment;
import com.example.topop.fragments.EstouLendoBooksFragment;
import com.example.topop.fragments.JaAssistiSeriesFragment;
import com.example.topop.fragments.JaLiBooksFragment;
import com.example.topop.fragments.QueroAssistirSeriesFragment;
import com.example.topop.fragments.QueroLerBooksFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class activity_list_serie extends AppCompatActivity {

    private TabLayout tabLayoutSerie;

    private JaAssistiSeriesFragment jaAssistiSeriesFragment;
    private QueroAssistirSeriesFragment queroAssistirSeriesFragment;
    private EstouAssistindoSeriesFragment estouAssistindoSeriesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_serie);

        tabLayoutSerie = (TabLayout) findViewById(R.id.TabLayoutSerie);

        jaAssistiSeriesFragment = new JaAssistiSeriesFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameSeries, jaAssistiSeriesFragment);
        transaction.commit();

        tabLayoutSerie.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameSeries, jaAssistiSeriesFragment);
                        transaction.commit();
                        break;
                    case 1:
                        queroAssistirSeriesFragment = new QueroAssistirSeriesFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameSeries, queroAssistirSeriesFragment);
                        transaction.commit();

                        break;
                    case 2:
                        estouAssistindoSeriesFragment = new EstouAssistindoSeriesFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameSeries, estouAssistindoSeriesFragment);
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
                        startActivity(new Intent(getApplicationContext(), activity_profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}