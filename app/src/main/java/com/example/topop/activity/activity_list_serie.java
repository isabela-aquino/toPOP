package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.topop.R;
import com.example.topop.fragments.EstouAssistindoSeriesFragment;
import com.example.topop.fragments.JaAssistiSeriesFragment;
import com.example.topop.fragments.QueroAssistirSeriesFragment;
import com.google.android.material.tabs.TabItem;

public class activity_list_serie extends AppCompatActivity {

    private TabItem tabIJaVi, tabIQueroVer, tabIEstouVendo;

    private JaAssistiSeriesFragment jaAssistiSeriesFragment;
    private QueroAssistirSeriesFragment queroAssistirSeriesFragment;
    private EstouAssistindoSeriesFragment estouAssistindoSeriesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_serie);

        tabIJaVi = findViewById(R.id.tablJaVi);
        tabIQueroVer = findViewById(R.id.tablQueroVer);
        tabIEstouVendo = findViewById(R.id.tabIEstouVendo);

        jaAssistiSeriesFragment = new JaAssistiSeriesFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameBooks, jaAssistiSeriesFragment);
        transaction.commit();

        tabIJaVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameBooks, jaAssistiSeriesFragment);
                transaction.commit();
            }
        });

        tabIQueroVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queroAssistirSeriesFragment = new QueroAssistirSeriesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameBooks, queroAssistirSeriesFragment);
                transaction.commit();
            }
        });

        tabIEstouVendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estouAssistindoSeriesFragment = new EstouAssistindoSeriesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameBooks, estouAssistindoSeriesFragment);
                transaction.commit();
            }
        });
    }
}