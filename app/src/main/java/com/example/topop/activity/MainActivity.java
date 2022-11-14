package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topop.R;


public class MainActivity extends AppCompatActivity {

    public Button entrar;
    public  Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrar = (Button) findViewById(R.id.btnEntrar);
        registrar = (Button) findViewById(R.id.btnRegistrar);


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaEntrar();
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaRegistrar();
            }
        });
    }

    public void abrirTelaEntrar(){
        Intent intent = new Intent(this, activity_login.class);
        startActivity(intent);
    }

    public void abrirTelaRegistrar(){
        Intent intent = new Intent(this, activity_registrar.class);
        startActivity(intent);
    }
}