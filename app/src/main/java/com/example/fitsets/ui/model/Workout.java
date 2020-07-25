package com.example.fitsets.ui.model;

import java.util.ArrayList;

public class Workout {
    String exercise, setname, sets, reps, weight, time, date;

    ///Constractor///
    public Workout(String exercise, String setname, String sets, String reps, String weight,String time, String date) {

        this.exercise = exercise;
        this.setname = setname;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.time = time;
        this.date = date;
    }

    public Workout(ArrayList<Workout> exercise) {
    }

    ////Setter And Gatter///
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

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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
