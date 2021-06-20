package com.example.timhortons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Order_Activity extends AppCompatActivity {
    private Query query;

    ImageView oImage;
    TextView oPrice;
    TextView oName;
    EditText oQuatity;
    Button oBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
     Intent i = getIntent();

     /*
      String key_send=i.getStringExtra("key_send");
       query= FirebaseDatabase.getInstance().getReference().child("Menu").child(key_send);
*/
        oQuatity=findViewById(R.id.oQuantity);
        oBtn=findViewById(R.id.oBtn);
        String price = i.getStringExtra("price");
        oPrice = findViewById(R.id.oPrice);
        oPrice.setText(price);

        String name = i.getStringExtra("name");
        oName = findViewById(R.id.oName);
        oName.setText(name);

        String image = i.getStringExtra("image");
        oImage = findViewById(R.id.oImage);

        StorageReference stoRef = FirebaseStorage.getInstance().getReferenceFromUrl(image);

        Glide.with(this).load(stoRef).into(oImage);
        oBtn.setOnClickListener(v -> {
            Intent intent =new Intent(v.getContext(),Checkout.class);



            intent.putExtra("name",name);
            intent.putExtra("price", price);
            intent.putExtra("image", image);
            intent.putExtra("quantity",oQuatity.getText().toString());
            v.getContext().startActivity(intent);

        });


    }
}