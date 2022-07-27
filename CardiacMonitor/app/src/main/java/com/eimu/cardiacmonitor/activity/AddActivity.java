package com.eimu.cardiacmonitor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eimu.cardiacmonitor.MyDatabaseHelper;
import com.eimu.cardiacmonitor.R;
import com.eimu.cardiacmonitor.model.CardiacModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList<CardiacModel> dataArrayList;
    Gson gson;

    EditText date_input,time_input,systolic_input,diastolic_input,heartrate_input,comment_input;
    String date, time, systolic, diastolic, heartrate, comment;
    Button save_button;
    CardiacModel cardiacModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        readData();

        date_input = findViewById(R.id.dateValue);
        time_input = findViewById(R.id.timeValue);
        systolic_input = findViewById(R.id.systolicValue);
        diastolic_input = findViewById(R.id.diastolicValue);
        heartrate_input = findViewById(R.id.heartRateValue);
        comment_input = findViewById(R.id.commentValue);
        save_button = findViewById(R.id.addButton);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = date_input.getText().toString();
                time = time_input.getText().toString();
                systolic = systolic_input.getText().toString();
                diastolic = diastolic_input.getText().toString();
                heartrate = heartrate_input.getText().toString();
                comment = comment_input.getText().toString();
                cardiacModel = new CardiacModel(date,time,systolic,diastolic,heartrate,comment);
                new DataList().addRecord(cardiacModel);
               // dataArrayList.add(cardiacModel);
                //DataList.array.add(cardiacModel);
                MainActivity.customAdapter.notifyDataSetChanged();
                writeData();
                finish();

                //public CardiacModel(Long id, String date, String time, String systolic, String diastolic, String heartRate, String comment) {
            }
        });

    }

    private void readData()
    {
        sharedPreferences = getSharedPreferences("faija",MODE_PRIVATE);
        gson = new Gson();
        String jsonString = sharedPreferences.getString("eimu",null);
        Type type = new TypeToken<ArrayList<CardiacModel>>(){}.getType();
        dataArrayList = gson.fromJson(jsonString,type);
        if(dataArrayList ==null)
        {
            dataArrayList = new ArrayList<>();
        }
    }


    private void writeData()
    {
        sharedPreferences = getSharedPreferences("faija",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        String jsonString = gson.toJson(dataArrayList);
        editor.putString("eimu",jsonString);
        editor.apply();
    }
}

