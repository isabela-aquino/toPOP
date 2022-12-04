package com.example.topop.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.topop.R;
import com.example.topop.activity.activity_book_details;
import com.example.topop.domain.Book;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    // creating variables for arraylist and context.
    private ArrayList<Book> BookArrayList;
    private Context mcontext;

    // creating constructor for array list and context.
    public BookAdapter(ArrayList<Book> BookArrayList, Context mcontext) {
        this.BookArrayList = BookArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout for item of recycler view item.
        View view = LayoutInflater.from(mcontext).inflate(R.layout.book_rv_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        // inside on bind view holder method we are
        // setting ou data to each UI component.
        Book book = BookArrayList.get(position);
        holder.nameTV.setText(book.getTitle());
        //holder.descriptionTV.setText(book.getDescription());
        holder.authorTV.setText(book.getAuthors().toString());
        //holder.bookIV.setImageBitmap(book.getThumbnail());


        // below line is use to set image from URL in our image view.
        //Picasso.get().load(book.getThumbnail()).into(holder.bookIV);

        // below line is use to add on click listener for our item of recycler view.
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(mcontext, activity_book_details.class);
//                i.putExtra("title", book.getTitle());
//                i.putExtra("authors", book.getAuthors());
//                i.putExtra("description", book.getDescription());
//                //i.putExtra("thumbnail", book.getThumbnail());
//
//                mcontext.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        // inside get item count method we
        // are returning the size of our array list.
        return BookArrayList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        // below line is use to initialize
        // our text view and image views.
        TextView nameTV, authorTV;
        //ImageView bookIV;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.TVTitle);
            //bookIV = itemView.findViewById(R.id.IVImage);
            authorTV = itemView.findViewById(R.id.TVAuthor);
            //descriptionTV = itemView.findViewById(R.id.descriptionBook);
        }
    }
}