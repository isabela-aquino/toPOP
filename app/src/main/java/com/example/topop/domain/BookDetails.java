package com.example.topop.domain;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.topop.R;

import java.util.ArrayList;

public class BookDetails extends AppCompatActivity {

    // creating variables for strings,text view, image views and button.
    String title, description, thumbnail;
    private ArrayList<String> authors;


    TextView titleTV, descTV, authorTV;

    ImageView bookIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        // initializing our views..
        titleTV = findViewById(R.id.titleBook);
        descTV = findViewById(R.id.descriptionBook);
        //authorTV = findViewById(R.id.autoraLivro);


        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        //authors = getIntent().getStringArrayListExtra("authors");
        //thumbnail = getIntent().getStringExtra("thumbnail");


        titleTV.setText(title);
        descTV.setText(description);
        //authorTV.setText((CharSequence) authors);
        //Picasso.get().load(thumbnail).into(bookIV);

    }
}