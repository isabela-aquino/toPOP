package com.example.topop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.topop.R;
import com.example.topop.adapters.BookAdapter;
import com.example.topop.domain.Book;
import com.example.topop.fragments.BooksRecyclerView;
import com.example.topop.fragments.SearchMovieFragment;
import com.example.topop.fragments.SearchSerieFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

public class activity_search extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private ArrayList<Book> bookInfoArrayList;
    private RequestQueue mRequestQueue;


    private EditText txtSearch;

    private static final Logger LOGGER = Logger.getLogger( activity_search.class.getName() );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.idRVBooks);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.TabLayoutSearch);


        txtSearch = findViewById(R.id.txtSearch);

        ImageButton btnSearch = findViewById(R.id.imageButton);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // checking if our edittext field is empty or not.
                // checking if our edittext field is empty or not.
                if (txtSearch.getText().toString().isEmpty()) {
                    txtSearch.setError("Please enter search query");
                    return;
                }
                // if the search query is not empty then we are
                // calling get book info method to load all
                // the books from the API.
                getBooksInfo(txtSearch.getText().toString());
            }
        });

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.search);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), activity_pagina_inicial.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), activity_profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private void getBooksInfo(String query) {

        // creating a new array list.
        bookInfoArrayList = new ArrayList<>();

        // below line is use to initialize
        // the variable for our request queue.
        mRequestQueue = Volley.newRequestQueue(activity_search.this);

        // below line is use to clear cache this
        // will be use when our data is being updated.
        mRequestQueue.getCache().clear();

        // below is the url for getting data from API in json format.
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;

        // below line we are  creating a new request queue.
        RequestQueue queue = Volley.newRequestQueue(activity_search.this);


        // below line is use to make json object request inside that we
        // are passing url, get method and getting json object. .
        JsonObjectRequest booksObjrequest = new JsonObjectRequest(Request.Method.GET, url, (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                // inside on response method we are extracting all our json data.
                try {
                    JSONArray itemsArray = response.getJSONArray("items");
                    for (int i = 0; i < itemsArray.length(); i++) {
                        JSONObject itemsObj = itemsArray.getJSONObject(i);
                        JSONObject volumeObj = itemsObj.getJSONObject("volumeInfo");
                        String title = volumeObj.getString("title");
                        String description;
                        String thumbnail;
                        JSONArray authorsArray;
                        if (volumeObj.has("authors")) {
                            authorsArray = volumeObj.getJSONArray("authors");
                        } else {
                            authorsArray = new JSONArray("Autor desconhecido");
                        }

                        if (volumeObj.has("description")){
                            description = volumeObj.getString("description");
                        } else {
                            description = "Sem descrição";
                        }
                        if (volumeObj.has("imageLinks")) {
                            JSONObject imageLinks = volumeObj.getJSONObject("imageLinks");
                            thumbnail = imageLinks.getString("thumbnail");
                        } else {
                            thumbnail = "https://amici.com.br/wp-content/uploads/sites/83/2020/04/imagem-indispon%C3%ADvel.jpg";
                            System.out.println(thumbnail);
                        }

                       ArrayList<String> authorsArrayList = new ArrayList<>();
                        if (authorsArray.length() != 0) {
                            for (int j = 0; j < authorsArray.length(); j++) {
                                authorsArrayList.add(authorsArray.optString(i));
                            }
                        }


                        // after extracting all the data we are
                        // saving this data in our modal class.
                        Book bookInfo = new Book(title, description, authorsArrayList, thumbnail);

                        // below line is use to pass our modal
                        // class in our array list.
                        bookInfoArrayList.add(bookInfo);

                        // below line is use to pass our
                        // array list in adapter class.
                        BookAdapter adapter = new BookAdapter(bookInfoArrayList, activity_search.this);

                        // below line is use to add linear layout
                        // manager for our recycler view.
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_search.this, RecyclerView.VERTICAL, false);
                        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.idRVBooks);

                        // in below line we are setting layout manager and
                        // adapter to our recycler view.
                        mRecyclerView.setLayoutManager(linearLayoutManager);
                        mRecyclerView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // displaying a toast message when we get any error from API
                    Toast.makeText(activity_search.this, "No Data Found" + e, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // also displaying error message in toast.
                Toast.makeText(activity_search.this, "Error found is " + error, Toast.LENGTH_SHORT).show();
            }
        });
        // at last we are adding our json object
        // request in our request queue.
        queue.add(booksObjrequest);

    }
}