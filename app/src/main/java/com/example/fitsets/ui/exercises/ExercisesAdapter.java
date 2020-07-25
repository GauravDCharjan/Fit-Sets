package com.example.fitsets.ui.exercises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fitsets.R;
import com.example.fitsets.ui.DatabaseHelper;
import com.example.fitsets.ui.model.Exercises;

import java.util.ArrayList;


public class ExercisesAdapter extends BaseAdapter {

    Context context;
    ArrayList<Exercises> exercises;
    DatabaseHelper databaseHelper;

    public ExercisesAdapter(Context context, ArrayList<Exercises> exercises){
        this.context=context;
        this.exercises=exercises;
    }
    @Override
    public int getCount() {
        return this.exercises.size();
    }

    @Override
    public Object getItem(int position) {
        return exercises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.listview_exercises,null);

        TextView exercise_name=(TextView) convertView.findViewById(R.id.exer_name);
        TextView set_name=(TextView) convertView.findViewById(R.id.sets_name);
        TextView dat=convertView.findViewById(R.id.exer_date);
        TextView tim=convertView.findViewById(R.id.exer_time);

        final Exercises exercis=exercises.get(position);

        exercise_name.setText(exercis.getExercise());
        set_name.setText(exercis.getSetname());
        dat.setText(exercis.getDate());
        tim.setText(exercis.getTime());

        return convertView;
    }
}
