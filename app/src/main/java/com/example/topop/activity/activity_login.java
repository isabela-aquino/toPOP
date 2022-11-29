package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topop.R;

public class activity_login extends AppCompatActivity {

    public Button btnTelaEntrar;
    public TextView textViewRegistrar;
    public ImageView imageViewVoltarLogin;
    private EditText textEmail;
    private  EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnTelaEntrar = (Button) findViewById(R.id.btnTelaEntrar);

        textViewRegistrar = (TextView) findViewById(R.id.TvRegistrese);

        imageViewVoltarLogin = (ImageView) findViewById(R.id.voltarLogin);

        textEmail = (EditText) findViewById(R.id.txtEmail);

        textPassword = (EditText) findViewById(R.id.txtPassword);

        btnTelaEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_pagina_inicial.class);
                startActivity(intent);
            }
        });

       textViewRegistrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent myIntent = new Intent(activity_login.this, activity_registrar.class);
               startActivity(myIntent);
           }
       });

       imageViewVoltarLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent myIntent = new Intent(activity_login.this, MainActivity.class);
               startActivity(myIntent);
           }
       });


    }

}