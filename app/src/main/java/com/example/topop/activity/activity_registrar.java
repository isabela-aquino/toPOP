package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.topop.R;

public class activity_registrar extends AppCompatActivity {

    public TextView textViewEntrarAgora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        textViewEntrarAgora = (TextView) findViewById(R.id.TvEntrarAgora);

        textViewEntrarAgora .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_registrar.this, activity_login.class);
                startActivity(myIntent);
            }
        });
    }
}