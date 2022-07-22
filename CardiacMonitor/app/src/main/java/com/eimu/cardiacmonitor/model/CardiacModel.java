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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSystolic() {
        return systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public String getComment() {
        return comment;
    }

    public long getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CardiacModel( String date, String time, String systolic, String diastolic, String heartRate, String comment) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heartRate;
        this.comment = comment;
    }

}
