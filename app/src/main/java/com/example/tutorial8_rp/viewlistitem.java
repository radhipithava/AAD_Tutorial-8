package com.example.tutorial8_rp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class viewlistitem extends AppCompatActivity {

    DBHelper db;
    ListView listview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewcontain);
        listview = findViewById(R.id.listview_item);

        db = new DBHelper(this);
        ArrayList<String> thelist = new ArrayList<String>();

        Cursor cursor = db.getListData();

        if (cursor.getCount() == 0) {
            Toast.makeText(viewlistitem.this, "Database was Empty....", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                thelist.add(cursor.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listview.setAdapter(listAdapter);
            }
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Cursor c = db.ShowListItemData();
                //c.moveToFirst();

                while(c.moveToNext()) {
                    String id = c.getString(0);
                    String name = c.getString(1);
                    String email = c.getString(2);
                    String password = c.getString(3);


                    String a = listview.getItemAtPosition(i).toString();
                    Log.d("msg", a);
                    Log.d("name",name);

                    if (name.equals(a)) {
                        Intent intent = new Intent(viewlistitem.this, UserDetail.class);
                        intent.putExtra("id", id);
                        intent.putExtra("name", name);
                        intent.putExtra("email", email);
                        intent.putExtra("password", password);
                        startActivity(intent);
                    }


                }
            }
        });



    }
}
