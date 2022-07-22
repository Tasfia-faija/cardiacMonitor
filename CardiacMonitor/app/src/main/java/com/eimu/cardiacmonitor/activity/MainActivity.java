package com.eimu.cardiacmonitor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eimu.cardiacmonitor.adapter.CustomAdapter;
import com.eimu.cardiacmonitor.MyDatabaseHelper;
import com.eimu.cardiacmonitor.R;
import com.eimu.cardiacmonitor.model.CardiacModel;
import com.eimu.cardiacmonitor.model.IClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class  MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<CardiacModel> dataArrayList;
     CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new MyDatabaseHelper(MainActivity.this);


        recyclerView = findViewById(R.id.recycleview);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(view -> {
            Intent intent  = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
            finish();
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        dataArrayList = new ArrayList<>();

        retreiveDataInArrays();
        customAdapter = new CustomAdapter(MainActivity.this,dataArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        customAdapter.setCustomClickListener(new CustomAdapter.CustomClickListener() {
            @Override
            public void customOnClick(int position, View v) {

            }

            @Override
            public void customOnLongClick(int position, View v) {

            }

            @Override
            public void onDeleteClick(int position) {
               // dataArrayList.remove(position);
                if(position != RecyclerView.NO_POSITION)
                {
                    myDB.deleteOneRow(""+(position));
                    dataArrayList.remove(position);
                    customAdapter.notifyItemRemoved(position);
                }

            }
        });




    }

    void  retreiveDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                CardiacModel cardiacModel = new CardiacModel();
                cardiacModel.id = cursor.getLong(0);
                cardiacModel.date = cursor.getString(1);
                cardiacModel.time = cursor.getString(2);
                cardiacModel.systolic = cursor.getString(3);
                cardiacModel.diastolic = cursor.getString(4);
                cardiacModel.heartRate = cursor.getString(5);
                cardiacModel.comment = cursor.getString(6);
                dataArrayList.add(cardiacModel);
            }
        }
    }

}