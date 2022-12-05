package com.example.topop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_login extends AppCompatActivity {

    public Button btnTelaEntrar;
    public TextView textViewRegistrar;
    public ImageView imageViewVoltarLogin;
    private EditText textEmail;
    private  EditText textPassword;
    String[] mensagens = {"Preencha todos os campos", "Login efetuado com sucesso"};
    public String nomeUsuario;

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

                String email = textEmail.getText().toString();
                String senha = textPassword.getText().toString();

                if(email.isEmpty()|| senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    AutenticarUsuario(view);
                }
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


    private void AutenticarUsuario(View view){
        String email = textEmail.getText().toString();
        String senha = textPassword.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    telaPrincipal();
                    nomeUsuario = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                } else {
                    String erro;
                    try{
                        throw task.getException();

                    }catch(Exception e){
                        erro = "Erro ao logar o usuário";

                    }
                    Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }

            }
        });

    }
    private void telaPrincipal() {
        Intent intent = new Intent(activity_login.this, activity_pagina_inicial.class);
        intent.putExtra("userName", nomeUsuario);
        startActivity(intent);
        finish();
    }

}