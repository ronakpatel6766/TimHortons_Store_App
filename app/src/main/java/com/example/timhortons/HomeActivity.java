package com.example.timhortons;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ViewPager2 vPager;
    private RecyclerView.Adapter adapter;
    Button btnClick;
    ArrayList<TimEvents> EventList = new ArrayList<>();
    Button btnLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);


        TimEvents m1 = new TimEvents("offer1");
        TimEvents m2 = new TimEvents("offer2");
//
        TimEvents m3 = new TimEvents("offer3");

        EventList.add(m1);
        EventList.add(m2);
        EventList.add(m3);

        vPager = findViewById(R.id.vPage);

        adapter = new TimAdapter(EventList,this);
        vPager.setAdapter(adapter);


        vPager.setClipChildren(false);
        vPager.setClipToPadding(false);
        vPager.setOffscreenPageLimit(3);


        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(4));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v =1-Math.abs(position);
                page.setScaleY(0.8f + v*0.2f);
            }

        });
        vPager.setPageTransformer(transformer);
        btnLocation=findViewById(R.id.btnLocation);
        btnLocation.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,Location_Activity.class);
            startActivity(intent);
        });

//
    }
}
