package com.example.fitsets.ui.model;

import java.util.ArrayList;

public class Exercises {
    String exercise, setname,time, date;

    //Constractor

    public Exercises(String exercise, String setname,String time,String dte) {
        this.exercise = exercise;
        this.setname = setname;
        this.time=time;
        this.date=dte;
    }
    public Exercises(ArrayList<Exercises> exercises) {
    }

    //Getter and Setter

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getSetname() {
        return setname;
    }

    public void setSetname(String setname) {
        this.setname = setname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
