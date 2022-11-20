package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.topop.R;
import com.example.topop.fragments.EstouLendoBooksFragment;
import com.example.topop.fragments.JaLiBooksFragment;
import com.example.topop.fragments.QueroLerBooksFragment;
import com.google.android.material.tabs.TabItem;

public class activity_list_books extends AppCompatActivity {

    private TabItem tabIJaLi, tabIQueroLer, tabIEstouLendo;

    private JaLiBooksFragment jaLiBooksFragment;
    private QueroLerBooksFragment queroLerBooksFragment;
    private EstouLendoBooksFragment estouLendoBooksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        tabIJaLi = findViewById(R.id.tablJaLi);
        tabIQueroLer = findViewById(R.id.tablQueroLer);
        tabIEstouLendo = findViewById(R.id.tabIEstouLendo);

        jaLiBooksFragment = new JaLiBooksFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudoBooks, jaLiBooksFragment);
        transaction.commit();

        tabIJaLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameConteudoBooks, jaLiBooksFragment);
                transaction.commit();
            }
        });

        tabIQueroLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queroLerBooksFragment = new QueroLerBooksFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameConteudoBooks, queroLerBooksFragment);
                transaction.commit();
            }
        });

        tabIEstouLendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estouLendoBooksFragment = new EstouLendoBooksFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameConteudoBooks, estouLendoBooksFragment);
                transaction.commit();
            }
        });
    }
}