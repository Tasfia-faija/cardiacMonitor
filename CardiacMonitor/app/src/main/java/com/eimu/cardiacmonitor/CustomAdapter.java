package com.eimu.cardiacmonitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList data_date,data_time,data_systolic,data_diastolic,data_heartrate,data_comment;

    int position;

    CustomAdapter(Context context, ArrayList data_date,ArrayList data_time, ArrayList data_systolic, ArrayList data_diastolic, ArrayList data_heartrate, ArrayList data_comment){
        this.context = context;
        this.data_date = data_date;
        this.data_time = data_time;
        this.data_systolic = data_systolic;
        this.data_diastolic = data_diastolic;
        this.data_heartrate = data_heartrate;
        this.data_comment = data_comment;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.patientsdata_row, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.data_date_txt.setText(String.valueOf(data_date.get(position)));
        holder.data_time_txt.setText(String.valueOf(data_time.get(position)));
        holder.data_systolic_txt.setText(String.valueOf(data_systolic.get(position)));
        holder.data_diastolic_txt.setText(String.valueOf(data_diastolic.get(position)));
        holder.data_heartrate_txt.setText(String.valueOf(data_heartrate.get(position)));
        holder.data_comment_txt.setText(String.valueOf(data_comment.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("date", String.valueOf(data_date.get(position)));

                intent.putExtra("systolic", String.valueOf(data_systolic.get(position)));
                intent.putExtra("diastolic", String.valueOf(data_diastolic.get(position)));
                intent.putExtra("heartrate", String.valueOf(data_heartrate.get(position)));
                intent.putExtra("data_comment", String.valueOf(data_comment.get(position)));

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data_date.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView  data_date_txt,data_systolic_txt,data_diastolic_txt,data_heartrate_txt;
        LinearLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            data_date_txt = itemView.findViewById(R.id.data_date_txt);
            data_systolic_txt = itemView.findViewById(R.id.data_systolic_txt);
            data_diastolic_txt = itemView.findViewById(R.id.data_diastolic_txt);
            data_heartrate_txt= itemView.findViewById(R.id.data_heartrate_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
