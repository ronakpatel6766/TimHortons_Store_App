package com.example.timhortons;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Queue;


public class Menu_layout extends AppCompatActivity {
    private RecyclerView rView;
    private Query query;

    private FirebaseRecyclerAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        rView = findViewById(R.id.rView);
        query= FirebaseDatabase.getInstance().getReference().child("Menu");
        FirebaseRecyclerOptions<Menu> options=new FirebaseRecyclerOptions.Builder<Menu>().setQuery(query,Menu.class).build();
        adapter= new MenuAdapter(options,this);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}
