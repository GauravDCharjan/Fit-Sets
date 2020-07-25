package com.example.fitsets.ui.exercises;

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
import com.example.fitsets.ui.model.Exercises;

import java.util.ArrayList;

public class ExercisesFragment extends Fragment {

    EditText exercisesname,setsname;
    DatabaseHelper database;
    ListView listView;
    ArrayList<Exercises> exercises;
    ExercisesAdapter exercisesAdapter;
   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.fragment_exercises,container,false);

       exercisesname=view.findViewById(R.id.exercisesname);
       setsname=view.findViewById(R.id.setsnam);
       listView=view.findViewById(R.id.exercises_list);

       database=new DatabaseHelper(getActivity());
       database.getWritableDatabase();

       exercises=new ArrayList<>();

       getDataInListView();

       view.findViewById(R.id.adde).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               database.Dataexercises(exercisesname.getText().toString(),setsname.getText().toString());
               Toast.makeText(getActivity(), "Data save", Toast.LENGTH_SHORT).show();

               getDataInListView();
           }
       });
       return view;
   }
    private void getDataInListView() {
        exercises=database.getData2();
        exercisesAdapter=new ExercisesAdapter(getActivity(),exercises);
        listView.setAdapter(exercisesAdapter);
        exercisesAdapter.notifyDataSetChanged();
    }
}