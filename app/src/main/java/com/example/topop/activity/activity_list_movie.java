package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.topop.R;
import com.example.topop.fragments.JaAssistiMoviesFragment;
import com.example.topop.fragments.QueroAssistirMoviesFragment;
import com.google.android.material.tabs.TabItem;

public class activity_list_movie extends AppCompatActivity {

    private TabItem tabIJaAssisti, tabIQueroAssistir;

    private JaAssistiMoviesFragment jaAssistiMoviesFragment;
    private QueroAssistirMoviesFragment queroAssistirMoviesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        tabIJaAssisti = findViewById(R.id.tablJaAssisti);
        tabIQueroAssistir = findViewById(R.id.tablQueroAssistir);


        jaAssistiMoviesFragment = new JaAssistiMoviesFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudoBooks, jaAssistiMoviesFragment);
        transaction.commit();

        tabIJaAssisti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameConteudoBooks, jaAssistiMoviesFragment);
                transaction.commit();
            }
        });

        tabIQueroAssistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queroAssistirMoviesFragment = new QueroAssistirMoviesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameConteudoBooks, queroAssistirMoviesFragment);
                transaction.commit();
            }
        });

    }
}