package com.example.timhortons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TimAdapter<onCreateView>extends RecyclerView.Adapter<TimAdapter.MyViewHolder> {
    private ArrayList<TimEvents> mDataset;
    public Context mContext;
    public  TimAdapter(ArrayList<TimEvents> EventList,Context context) {
        mDataset = EventList;
        mContext=  context;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

       // TextView textView;
        ImageView mImg;


        MyViewHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.tim_adapter, parent, false));
            View v = inflater.inflate(R.layout.tim_adapter,parent,false);
           // textView = itemView.findViewById(R.id.txtMovie);
            mImg = itemView.findViewById(R.id.tImg);

        }


    }

    @NonNull
    @Override
    public TimAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position){
        TimEvents p = mDataset.get(position);
        Context actContext = holder.itemView.getContext();
        int resid =actContext.getResources().getIdentifier(p.gettImg(),"drawable",actContext.getPackageName());
        holder.mImg.setImageResource(resid);
        holder.mImg.setOnClickListener(v -> {
            Intent HomeIntent = new Intent(mContext,Menu_layout.class);
            mContext.startActivity(HomeIntent);




        });
    }
    @Override
    public int getItemCount(){
        return mDataset.size();
    }



}
