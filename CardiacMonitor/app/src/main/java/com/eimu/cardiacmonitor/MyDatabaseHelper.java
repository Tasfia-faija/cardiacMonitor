package com.eimu.cardiacmonitor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private  Context context;
    private static final String DATABASE_NAME = "CardiacLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private  static  final String  TABLE_NAME = "cardiac_monitor";
    private  static  final String  COLUMN_ID = "_id";
    private  static  final String  COLUMN_DATE_MEASURE = "date_measure";
    private  static  final String  COLUMN_TIME_MEASURE = "time_measure";
    private  static  final String  COLUMN_SYSTOLIC = "systolic";
    private  static  final String  COLUMN_DIASTOLIC = "diastolic";
    private  static  final String  COLUMN_HEART_RATE = "heart_rate";
    private  static  final String  COLUMN_COMMENT = "comment";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String query = "CREATE TABLE " + TABLE_NAME +
                                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                COLUMN_DATE_MEASURE + " TEXT, "+
                                COLUMN_TIME_MEASURE + " TEXT, "+
                                COLUMN_SYSTOLIC + " TEXT, " +
                                COLUMN_DIASTOLIC + " TEXT, "+
                                COLUMN_HEART_RATE + " TEXT ," +
                                COLUMN_COMMENT + " TEXT);";
       db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void patientRecord(String date, String time, String systolic, String diastolic, String heart_rate, String comment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE_MEASURE, date);
        cv.put(COLUMN_TIME_MEASURE, time);
        cv.put(COLUMN_SYSTOLIC, systolic);
        cv.put(COLUMN_DIASTOLIC, diastolic);
        cv.put(COLUMN_HEART_RATE, heart_rate);
        cv.put(COLUMN_COMMENT, comment);
        long result  = db.insert(TABLE_NAME,null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Sucessfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null){
            cursor=db.rawQuery(query, null);
        }
        return  cursor;
    }
}
