package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.topop.R;

public class activity_login extends AppCompatActivity {

    public Button btnTelaEntrar;
    public TextView textViewRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnTelaEntrar = (Button) findViewById(R.id.btnTelaEntrar);

        textViewRegistrar = (TextView) findViewById(R.id.TvRegistrese);

        btnTelaEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaInicial();
            }
        });

       textViewRegistrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent myIntent = new Intent(activity_login.this, activity_registrar.class);
               startActivity(myIntent);
           }
       });
    }

    public void abrirTelaInicial(){
        Intent intent = new Intent(this, activity_pagina_inicial.class);
        startActivity(intent);
    }
}