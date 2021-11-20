package com.example.tutorial8_rp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class homeactivity extends AppCompatActivity {
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        Intent i =new Intent(homeactivity.this,viewlistitem.class);
        startActivity(i);
        db =new DBHelper(this);


    }
}