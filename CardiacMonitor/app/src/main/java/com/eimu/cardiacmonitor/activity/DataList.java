package com.eimu.cardiacmonitor.activity;

import com.eimu.cardiacmonitor.model.CardiacModel;

import java.util.ArrayList;

public class DataList {
    public static ArrayList<CardiacModel> array = new ArrayList<>();
    /**
     *
     */
    public void addRecord(CardiacModel modelClass){
        if(array.contains(modelClass)){
            throw new IllegalArgumentException();
        }
        array.add(modelClass);


    }
    public void deleteRecord(int position){


        if (position>=0 && position<array.size()) {
            array.remove(position);
        }
        else {
            throw new IllegalArgumentException() ;
        }


    }
    public int  count(){
        return  array.size();
    }
}