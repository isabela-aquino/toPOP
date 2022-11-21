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
import com.google.android.material.tabs.TabLayout;

public class activity_list_books extends AppCompatActivity {

    private TabLayout tabLayout;

    private JaLiBooksFragment jaLiBooksFragment;
    private QueroLerBooksFragment queroLerBooksFragment;
    private EstouLendoBooksFragment estouLendoBooksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        tabLayout = (TabLayout) findViewById(R.id.TabLayoutBooks);

        jaLiBooksFragment = new JaLiBooksFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudoBooks, jaLiBooksFragment);
        transaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameConteudoBooks, jaLiBooksFragment);
                        transaction.commit();
                        break;
                    case 1:
                        queroLerBooksFragment = new QueroLerBooksFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameConteudoBooks, queroLerBooksFragment);
                        transaction.commit();

                        break;
                    case 2:
                        estouLendoBooksFragment = new EstouLendoBooksFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameConteudoBooks, estouLendoBooksFragment);
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