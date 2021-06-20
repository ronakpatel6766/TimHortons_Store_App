package com.example.timhortons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Location_Activity extends AppCompatActivity {
    private RecyclerView rView;
    private Query query;

    private FirebaseRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


            rView = findViewById(R.id.rView);
            query= FirebaseDatabase.getInstance().getReference().child("Location");
            FirebaseRecyclerOptions<Location> options=new FirebaseRecyclerOptions.Builder<Location>().setQuery(query,Location.class).build();
            adapter= new LocationAdapter(options);
            rView.setLayoutManager(new LinearLayoutManager(this));
            rView.setAdapter(adapter);
        }

        @Override
        protected void onStart() {
            super.onStart();
            adapter.startListening();
        }
    }
