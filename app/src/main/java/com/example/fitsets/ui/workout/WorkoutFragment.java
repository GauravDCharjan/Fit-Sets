package com.example.fitsets.ui.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fitsets.R;
import com.example.fitsets.ui.DatabaseHelper;
import com.example.fitsets.ui.model.Workout;

import java.util.ArrayList;

public class WorkoutFragment extends Fragment {

    EditText exercisename,setname,sets,reps,weight;
    DatabaseHelper database;
    ListView listView;
    ArrayList<Workout> exercise;
    WorkoutAdapter workoutAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_workout, container, false);

        exercisename=view.findViewById(R.id.exername);
        setname=view.findViewById(R.id.setnam);
        sets=view.findViewById(R.id.setnu);
        reps=view.findViewById(R.id.repsnu);
        weight=view.findViewById(R.id.weigh);
        listView=view.findViewById(R.id.workout_list);

        database=new DatabaseHelper(getActivity());
        database.getWritableDatabase();

        exercise=new ArrayList<>();

        getDataInListView();

        view.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.Dataworkout(exercisename.getText().toString(),setname.getText().toString(),sets.getText().toString(),
                        reps.getText().toString(),weight.getText().toString());
                Toast.makeText(getActivity(), "Data save", Toast.LENGTH_SHORT).show();

                getDataInListView();
            }
        });
        return view;
    }
    private void getDataInListView() {
        exercise=database.getData1();
        workoutAdapter=new WorkoutAdapter(getActivity(),exercise);
        listView.setAdapter(workoutAdapter);
        workoutAdapter.notifyDataSetChanged();
    }
}