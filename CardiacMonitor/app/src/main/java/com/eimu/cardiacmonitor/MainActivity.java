package com.eimu.cardiacmonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class  MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> data_id, data_date, data_time,data_systolic,data_diastolic,data_heartrate,data_comment;
     CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        data_id = new ArrayList<>();
        data_date = new ArrayList<>();
        data_time = new ArrayList<>();
        data_systolic = new ArrayList<>();
        data_diastolic = new ArrayList<>();
        data_heartrate = new ArrayList<>();
        data_comment = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this, data_date,data_systolic,data_diastolic,data_heartrate);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }

    void  storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                data_id.add(cursor.getString(0));
                data_date.add(cursor.getString(1));
                data_time.add(cursor.getString(2));
                data_systolic.add(cursor.getString(3));
                data_diastolic.add(cursor.getString(4));
                data_heartrate.add(cursor.getString(5));
                data_comment.add(cursor.getString(6));
            }
        }
    }

}