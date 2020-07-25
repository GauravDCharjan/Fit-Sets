package com.example.fitsets.ui.workout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fitsets.R;
import com.example.fitsets.ui.DatabaseHelper;
import com.example.fitsets.ui.model.Workout;

import java.util.ArrayList;


public class WorkoutAdapter extends BaseAdapter {

    Context context;
    ArrayList<Workout> exercise;
DatabaseHelper databaseHelper;

    public WorkoutAdapter(Context context, ArrayList<Workout> exercise){
        this.context=context;
        this.exercise=exercise;
    }

    @Override
    public int getCount() {
        return this.exercise.size();
    }

    @Override
    public Object getItem(int position) {
        return exercise.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.listview_workout,null);

        TextView exercise_name=(TextView) convertView.findViewById(R.id.exer_name);
        TextView set_name=(TextView) convertView.findViewById(R.id.sets_name);
        TextView set_no=(TextView) convertView.findViewById(R.id.set);
        TextView reps_no=(TextView) convertView.findViewById(R.id.rep);
        TextView weight_kg=(TextView) convertView.findViewById(R.id.weigh);
        TextView time_min=(TextView) convertView.findViewById(R.id.times);
        TextView date_current=(TextView) convertView.findViewById(R.id.dates);

        final Workout workout=exercise.get(position);

        exercise_name.setText(workout.getExercise());
        set_name.setText(workout.getSetname());
        set_no.setText(workout.getSets());
        reps_no.setText(workout.getReps());
        weight_kg.setText(workout.getWeight());
        time_min.setText(workout.getTime());
        date_current.setText(workout.getDate());

        return convertView;
    }
}