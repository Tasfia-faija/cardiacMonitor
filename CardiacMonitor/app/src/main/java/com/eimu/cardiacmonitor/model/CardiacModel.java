package com.eimu.cardiacmonitor.model;

import java.io.Serializable;

public class CardiacModel implements Serializable {
    public String date, time, systolic, diastolic, heartRate, comment;
    public long id;
    public CardiacModel() {
        this.id = 0L;
        this.date = "";
        this.time = "";
        this.systolic = "";
        this.diastolic = "";
        this.heartRate = "";
        this.comment = "";
    }

    public CardiacModel(Long id,String date, String time, String systolic, String diastolic, String heartRate, String comment) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heartRate;
        this.comment = comment;
    }
}
