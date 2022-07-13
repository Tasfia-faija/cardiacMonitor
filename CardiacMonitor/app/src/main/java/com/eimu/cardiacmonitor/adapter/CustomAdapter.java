package com.eimu.cardiacmonitor.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eimu.cardiacmonitor.R;
import com.eimu.cardiacmonitor.activity.ViewActivity;
import com.eimu.cardiacmonitor.model.CardiacModel;
import com.eimu.cardiacmonitor.model.IClickListener;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<CardiacModel> data;
    private IClickListener listener;
    int position;

    public CustomAdapter() {
        this.data = new ArrayList<>();
    }

   public CustomAdapter(@NonNull ArrayList<CardiacModel> data) {
        this.data = data;
    }

    public void updateData(@NonNull ArrayList<CardiacModel> data) {
        this.data = data;
    }

    public void setListener(IClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.patientsdata_row, parent, false));
    }

    @Override

    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardiacModel model = data.get(position);
        holder.loadView(model);
        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onClick(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView data_date_txt, data_systolic_txt, data_diastolic_txt, data_heartrate_txt;



        void loadView(CardiacModel model) {
            data_date_txt.setText(model.date);
            //holder.data_time_txt.setText(String.valueOf(data_time.get(position)));
            data_systolic_txt.setText(model.systolic);
            data_diastolic_txt.setText(model.diastolic);
            data_heartrate_txt.setText(model.heartRate);
            //holder.data_comment_txt.setText(String.valueOf(data_comment.get(position)));
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            data_date_txt = itemView.findViewById(R.id.data_date_txt);
            data_systolic_txt = itemView.findViewById(R.id.data_systolic_txt);
            data_diastolic_txt = itemView.findViewById(R.id.data_diastolic_txt);
            data_heartrate_txt = itemView.findViewById(R.id.data_heartrate_txt);

        }

    }
}
