package com.example.fitsets.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fitsets.R;
import com.example.fitsets.ui.DatabaseHelper;
import com.example.fitsets.ui.model.BodyTrack;

import java.util.ArrayList;

public class BodyTrackFragment extends Fragment {

    private MainViewModel mViewModel;
    Spinner spinner;
    String partname[]={"Left Biceps","Right Biceps","Chest","Waist","Hips","Left Thigh","Right Thigh","Left Calves","Right Calves"};

    EditText size;
    DatabaseHelper database;
    ListView listView;
    ArrayList<BodyTrack> partnam;
    BodyTrackAdapter bodyTrackAdapter;

    public static BodyTrackFragment newInstance() {
        return new BodyTrackFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.main_fragment, container, false);

        spinner=view.findViewById(R.id.spin);
        ArrayAdapter ad=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,partname);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s=parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), "Body Part="+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        size=view.findViewById(R.id.size);
        listView=view.findViewById(R.id.part_list);

        database=new DatabaseHelper(getActivity());
        database.getWritableDatabase();

        partnam=new ArrayList<>();

        getDataInListView();

        view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.Databodytrack(spinner.getSelectedItem().toString(),size.getText().toString());
                Toast.makeText(getActivity(), "Data save", Toast.LENGTH_SHORT).show();

                getDataInListView();
            }
        });
        return view;
    }
    private void getDataInListView() {
        partnam=database.getData3();
        bodyTrackAdapter=new BodyTrackAdapter(getActivity(),partnam);
        listView.setAdapter(bodyTrackAdapter);
        bodyTrackAdapter.notifyDataSetChanged();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}