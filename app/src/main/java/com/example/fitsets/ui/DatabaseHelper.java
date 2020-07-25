package com.example.fitsets.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fitsets.ui.model.BodyTrack;
import com.example.fitsets.ui.model.Exercises;
import com.example.fitsets.ui.model.Workout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String databasename="work.db";
    private static final int databaseversion=1;
    private static final String tablename1="workout_table";
    private static final String tablename2="exercises_table";
    private static final String tablename3="bodytrack_table";
    private Context context;
    String date,dates,datep;
    String time,dte;
    public DatabaseHelper(Context context){
        super(context,databasename,null,databaseversion);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1="CREATE TABLE "+tablename1+ "(exercise TEXT,setname TEXT,sets Number,reps Number,weight Number,date TEXT)";
        db.execSQL(table1);

        String table2="CREATE TABLE "+tablename2+ "(exercises TEXT,setsname TEXT,date TEXT)";
        db.execSQL(table2);

        String table3 = "CREATE TABLE " + tablename3 + "(partname TEXT,size Number,date TEXT)";
        db.execSQL(table3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String table1="DROP TABLE IF EXISTS "+tablename1;
        String table2="DROP TABLE IF EXISTS "+tablename2;
        String table3="DROP TABLE IF EXISTS "+ tablename3;
        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
        onCreate(db);
    }
    public void Dataworkout(String exercise, String setname, String sets, String reps, String weight){

        date=new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date());
        //For workout table
        ContentValues contentValues1=new ContentValues();

        contentValues1.put("exercise",exercise);
        contentValues1.put("setname",setname);
        contentValues1.put("sets",sets);
        contentValues1.put("reps",reps);
        contentValues1.put("weight",weight);
        contentValues1.put("date", date);

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.insert(tablename1,null,contentValues1);
    }
    public void Dataexercises(String exercises,String setsname){
        dates=new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date());
        //For exercises table
        ContentValues Values2=new ContentValues();
        Values2.put("exercises",exercises);
        Values2.put("setsname",setsname);
        Values2.put("date", dates);

        SQLiteDatabase sqLiteDatabas=this.getWritableDatabase();
        sqLiteDatabas.insert(tablename2,null,Values2);
    }

    public void Databodytrack(String partname, String size) {
        datep= new SimpleDateFormat("dd/MM/yyyy HH:mm ", Locale.getDefault()).format(new Date());
        //For bodytrack table
        ContentValues contentValues3 = new ContentValues();

        contentValues3.put("partname", partname);
        contentValues3.put("size", size);
        contentValues3.put("date",datep);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(tablename3, null, contentValues3);
    }

    //For workout table
    public ArrayList<Workout> getData1(){
        ArrayList<Workout> exercises=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + tablename1, null);

        try{
            if (cursor.moveToLast()) {

                do{
                    String exercise,setname,sets,reps,weight,date;

                    exercise=cursor.getString(0);
                    setname=cursor.getString(1);
                    sets=cursor.getString(2);
                    reps=cursor.getString(3);
                    weight=cursor.getString(4);
                    date=cursor.getString(5);
                    dte=date.substring(0,date.indexOf(" "));
                    time=date.substring(date.indexOf(" ")+1);

                    Workout workout=new Workout(exercise,setname,sets,reps,weight,time,dte);

                    exercises.add(workout);
                }while (cursor.moveToPrevious());
            }
        }finally{
            cursor.close();
        }
        return exercises;
    }

    //For exercises table
    public ArrayList<Exercises> getData2(){
        ArrayList<Exercises> exercises=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + tablename2, null);

        try{
            if (cursor.moveToLast()) {

                do{
                    String exercisesname,setsname,date;

                    exercisesname=cursor.getString(0);
                    setsname=cursor.getString(1);
                    date=cursor.getString(2);
                    dte=date.substring(0,date.indexOf(" "));
                    time=date.substring(date.indexOf(" ")+1);

                    Exercises exercis=new Exercises(exercisesname,setsname,time,dte);

                    exercises.add(exercis);
                }while (cursor.moveToPrevious());
            }
        }finally{
            cursor.close();
        }
        return exercises;
    }


    //For bodytrack table
    public ArrayList<BodyTrack> getData3(){
        ArrayList<BodyTrack> partnam=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + tablename3, null);

        try{
            if (cursor.moveToLast()) {

                do{
                    String partname,size,datecurrent;

                    partname=cursor.getString(0);
                    size=cursor.getString(1);
                    datecurrent=cursor.getString(2);
                    dte=datecurrent.substring(0,datecurrent.indexOf(" "));
                    time=datecurrent.substring(datecurrent.indexOf(" ")+1);

                    BodyTrack bodyTrack=new BodyTrack(partname,size,time,dte);

                    partnam.add(bodyTrack);
                }while (cursor.moveToPrevious());
            }
        }finally{
            cursor.close();
        }
        return partnam;
    }

   /* public void deleteData(String finalid){
        String dt=finalid;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(tablename1, dt,null);
    }*/
}