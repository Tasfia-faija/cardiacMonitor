package com.eimu.cardiacmonitor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eimu.cardiacmonitor.MyDatabaseHelper;
import com.eimu.cardiacmonitor.R;

public class AddActivity extends AppCompatActivity {

    EditText date_input,time_input,systolic_input,diastolic_input,heartrate_input,comment_input;
    Button save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

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
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.patientRecord(date_input.getText().toString().trim(),
                        time_input.getText().toString().trim(),
                        systolic_input.getText().toString().trim(),
                        diastolic_input.getText().toString().trim(),
                        heartrate_input.getText().toString().trim(),
                        comment_input.getText().toString().trim());
            }
        });

    }
}

//crash korse same vabe