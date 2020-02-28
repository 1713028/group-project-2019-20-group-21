package com.example.house;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView Price,Area,Date;
    Button button;
    DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Price=(TextView)findViewById(R.id.textView);
        Area=(TextView)findViewById(R.id.textView2);
        Date=(TextView)findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                mDatabase = FirebaseDatabase.getInstance().getReference().child("0005D6DD-9127-46B6-AED6-C3457DA4015A");
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String price = dataSnapshot.child("Price").getValue().toString();
                        String area = dataSnapshot.child("Postcode").getValue().toString();
                        String date = dataSnapshot.child("date").getValue().toString();

                        Price.setText(price);
                        Area.setText(area);
                        Date.setText(date);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

        });
    }
}
