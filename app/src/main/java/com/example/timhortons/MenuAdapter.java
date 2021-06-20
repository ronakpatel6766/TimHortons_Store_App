package com.example.timhortons;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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



public class MenuAdapter extends FirebaseRecyclerAdapter<Menu,MenuAdapter.MenuHolder> {

    public Context mContext;
    public MenuAdapter(FirebaseRecyclerOptions<Menu> options,Context context){
        super(options);
        mContext=context;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MenuHolder(layoutInflater,parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull MenuHolder holder, int position,Menu modle) {
        StorageReference stoRef = FirebaseStorage.getInstance().getReferenceFromUrl(modle.getImage());
        Context actContext = holder.itemView.getContext();
        Glide.with(holder.mImage.getContext()).load(stoRef).into(holder.mImage);

        holder.txtName.setText(modle.getName());
        holder.txtPrice.setText(modle.getPrice());






    }

    class MenuHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtName;
        TextView txtPrice;
        ImageView mImage;

        public MenuHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.row__layout,parent,false));
            txtName=itemView.findViewById(R.id.txtName);
            txtPrice=itemView.findViewById(R.id.txtPrice);
            mImage=itemView.findViewById(R.id.mImage);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {


          //  String Key_send=getSnapshots().getSnapshot(getAdapterPosition()).getKey();

            Menu m = getItem(getAdapterPosition());

            String name = m.getName();
            String price = m.getPrice();
            String image = m.getImage();
            Intent i =new Intent(v.getContext(),Order_Activity.class);



            i.putExtra("name",name);
            i.putExtra("price", price);
            i.putExtra("image", image);
            v.getContext().startActivity(i);
        }
    }

}
