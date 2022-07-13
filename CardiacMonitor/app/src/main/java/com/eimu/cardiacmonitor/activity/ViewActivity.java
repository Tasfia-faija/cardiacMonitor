package com.eimu.cardiacmonitor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.eimu.cardiacmonitor.R;
import com.eimu.cardiacmonitor.model.CardiacModel;

public class ViewActivity extends AppCompatActivity {
    static String CARDIAC_MODEL = "CardiacModel";
    TextView date_view,time_view,systolic_view,diastolic_view,heartrate_view,comment_view;
    CardiacModel cardiacModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        date_view = findViewById(R.id.DateValue_view);
        time_view = findViewById(R.id.TimeValue_view);
        systolic_view = findViewById(R.id.SystolicValue_view);
        diastolic_view = findViewById(R.id.DiastolicValue_view);
        heartrate_view = findViewById(R.id.HeartRateValue_view);
        comment_view = findViewById(R.id.CommentValue_view);

        //void getAndSetIntentData();
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra(CARDIAC_MODEL)){
            cardiacModel = (CardiacModel) getIntent().getSerializableExtra(CARDIAC_MODEL);
         date_view.setText(cardiacModel.date);
            time_view.setText(cardiacModel.time);
            systolic_view.setText(cardiacModel.systolic);
            diastolic_view.setText(cardiacModel.diastolic);
            heartrate_view.setText(cardiacModel.heartRate);
            comment_view.setText(cardiacModel.comment);
        }
        else
        {
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
        }
    }
}