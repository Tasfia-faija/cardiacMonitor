package com.eimu.cardiacmonitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList data_date,data_systolic,data_diastolic,data_heartrate;

    CustomAdapter(Context context, ArrayList data_date, ArrayList data_systolic, ArrayList data_diastolic, ArrayList data_heartrate){
        this.context = context;
        this.data_date = data_date;
        this.data_systolic = data_systolic;
        this.data_diastolic = data_diastolic;
        this.data_heartrate = data_heartrate;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.patientsdata_row, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.data_date_txt.setText(String.valueOf(data_date.get(position)));
        holder.data_systolic_txt.setText(String.valueOf(data_systolic.get(position)));
        holder.data_diastolic_txt.setText(String.valueOf(data_diastolic.get(position)));
        holder.data_heartrate_txt.setText(String.valueOf(data_heartrate.get(position)));
    }

    @Override
    public int getItemCount() {
        return data_date.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView  data_date_txt,data_systolic_txt,data_diastolic_txt,data_heartrate_txt;

        public MyViewHolder(View itemView) {
            super(itemView);
            data_date_txt = itemView.findViewById(R.id.data_date_txt);
            data_systolic_txt = itemView.findViewById(R.id.data_systolic_txt);
            data_diastolic_txt = itemView.findViewById(R.id.data_diastolic_txt);
            data_heartrate_txt= itemView.findViewById(R.id.data_heartrate_txt);
        }
    }
}
