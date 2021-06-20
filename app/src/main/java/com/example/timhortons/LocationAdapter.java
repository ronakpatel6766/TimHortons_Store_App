package com.example.timhortons;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class LocationAdapter extends FirebaseRecyclerAdapter<Location,LocationAdapter.LocationHolder> {

    public Context mContext;
    public LocationAdapter(FirebaseRecyclerOptions<Location> options){
        super(options);
    }

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new LocationHolder(layoutInflater,parent);
    }


    protected void onBindViewHolder(@NonNull LocationHolder holder, int position, Location modle) {
        StorageReference stoRef = FirebaseStorage.getInstance().getReferenceFromUrl(modle.getImage());
        Glide.with(holder.sImage.getContext()).load(stoRef).into(holder.sImage);
        holder.sLocation.setText(modle.getLoc());
        holder.sName.setText(modle.getName());
        holder.sLocation.setOnClickListener(v -> {

        });





    }

    class LocationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView sLocation;
        TextView sName;
        ImageView sImage;

        public LocationHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.location_row_layout,parent,false));
            itemView.setOnClickListener(this);
            sLocation=itemView.findViewById(R.id.sLocation);
            sName=itemView.findViewById(R.id.sName);
            sImage=itemView.findViewById(R.id.sImage);



        }

        @Override
        public void onClick(View v) {
            String locationString = getItem(getLayoutPosition()).getLoc();
            Uri gmmInetntUri = Uri.parse("geo:" +locationString);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmInetntUri);
            itemView.getContext().startActivity(mapIntent);
        }
    }

}
