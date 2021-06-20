package com.example.timhortons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Date;

public class Checkout extends AppCompatActivity {

    private ImageView txtCheckoutimage;
    private ImageView Checkoutimage;
    private TextView txtCheckoutquantity;
    private TextView txtCheckout;
    private TextView txtCheckoutName;
    private Button btnCheckout;
    private EditText txtCardNumber,txtEmail,txtExpiryDate,txtCusName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);



        txtCheckout= findViewById(R.id.txtCheckout);
        txtCheckoutimage= findViewById(R.id.txtCheckoutimage);
        txtCheckoutquantity= findViewById(R.id.txtCheckoutquantity);
        Checkoutimage= findViewById(R.id.Checkoutimage);
        txtCheckoutName=findViewById(R.id.txtCheckoutName);
        btnCheckout = findViewById(R.id.btncheckout);
        txtCardNumber=findViewById(R.id.txtCardNumber);
        txtEmail=findViewById(R.id.txtEmail);
        txtExpiryDate=findViewById(R.id.txtExpiryDate);
        txtCusName = findViewById(R.id.txtCusName);

        Bundle bundle=getIntent().getExtras();

        String name = bundle.getString("name");
        txtCheckoutName.setText(name);

        String quantity = bundle.getString("quantity");
        txtCheckoutquantity.setText(quantity);


        String image = bundle.getString("image");
        StorageReference stoRef = FirebaseStorage.getInstance().getReferenceFromUrl(image);
        Glide.with(this).load(stoRef).into(Checkoutimage);

//        btnCheckout.setOnClickListener(v -> {
//            Intent intent = new Intent(Checkout.this,Display_Activity.class);
//            startActivity(intent);
//
//
//        });
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (validate()) {
                    Intent intent = new Intent(Checkout.this,Display_Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Checkout.this, "Please enter valid information",
                            Toast.LENGTH_LONG).show();
                }

            }



    private boolean validate(){
        boolean valid = true;

        String name = txtCusName.getText().toString();
        String emailid = txtEmail.getText().toString();
        String expirydate = txtExpiryDate.getText().toString();
        String cardnum = txtCardNumber.getText().toString();

        System.out.println(name);
        System.out.println(emailid);
        System.out.println(expirydate);
        System.out.println(cardnum);


        if (name.isEmpty() || name.length() < 3) {
            txtCusName.setError("Min. 3 Characters");
            valid = false;
        } else {
            txtCusName.setError(null);
        }

        if (emailid.isEmpty() || emailid.length() < 10) {
            txtEmail.setError("Min. 10 Characters");
            valid = false;
        } else {
            txtEmail.setError(null);
        }
//


        if (expirydate.isEmpty() || expirydate.length() < 4) {
            txtExpiryDate.setError("Min. 4 Characters");
            valid = false;
        } else {
            txtExpiryDate.setError(null);
        }

        if (cardnum.isEmpty() || cardnum.length() < 16) {
            txtCardNumber.setError("Min. 16 digits");
            valid = false;
        } else {
            txtCardNumber.setError(null);
        }
        return valid;
            };

});
    }
};

