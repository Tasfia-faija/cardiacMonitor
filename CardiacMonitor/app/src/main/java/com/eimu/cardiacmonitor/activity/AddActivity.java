package com.eimu.cardiacmonitor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eimu.cardiacmonitor.R;
import com.eimu.cardiacmonitor.model.CardiacModel;
import com.google.gson.Gson;

public class AddActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    //ArrayList<CardiacModel> dataArrayList;
    Gson gson;

    EditText date_input,time_input,systolic_input,diastolic_input,heartrate_input,comment_input;
    String date, time, systolic, diastolic, heartrate, comment;
    Button save_button;
    CardiacModel cardiacModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //readData();

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
                DataList.array.add(cardiacModel);
                //  new DataList().addRecord(cardiacModel);
                PreferenceManager.getDefaultSharedPreferences(AddActivity.this).edit().clear().commit();
                writeData();
                // dataArrayList.add(cardiacModel);
                //DataList.array.add(cardiacModel);
                MainActivity.customAdapter.notifyDataSetChanged();
                Toast.makeText(AddActivity.this,"Data Insertion Successful",Toast.LENGTH_LONG).show();


                finish();

                //public CardiacModel(Long id, String date, String time, String systolic, String diastolic, String heartRate, String comment) {
            }
        });

    }




    private void writeData()
    {
        sharedPreferences = getSharedPreferences("faija",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        String jsonString = gson.toJson(DataList.array);
        editor.putString("eimu",jsonString);
        editor.apply();
    }
}