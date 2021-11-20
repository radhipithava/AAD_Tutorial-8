package com.example.tutorial8_rp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserDetail extends AppCompatActivity {


    TextView id, username, email, password;
    Button backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        id = findViewById(R.id.userid);
        username = findViewById(R.id.username);
        email = findViewById(R.id.useremail);
        password = findViewById(R.id.userpassword);
        backbtn = findViewById(R.id.back_btn);



        Intent intent = getIntent();
        String id1 = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String email1 =intent.getStringExtra("email");
        String password1 = intent.getStringExtra("password");

        id.setText(id1);
        username.setText(name);
        email.setText(email1);
        password.setText(password1);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(getApplicationContext(),viewlistitem.class);

                id.setText("");
                username.setText("");
                email.setText("");
                password.setText("");
                startActivity(in);
                finish();


            }
        });






//        int id1 = intent.getIntExtra("id", 0);
//
//        if (id1 != 0) {
//
//            d1.ShowListItemData();
//            Toast.makeText(getApplicationContext(), "Data loaded..", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
//        }






    }
}