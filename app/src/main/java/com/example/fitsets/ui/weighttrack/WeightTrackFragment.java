package com.example.fitsets.ui.weighttrack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fitsets.R;

public class WeightTrackFragment extends Fragment {

    float a,w,h,bmimf,bfpmf,ffmimf;
    EditText age,weight,height;
    TextView bmi,bfp,ffmi;
   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_weighttrack, container, false);

       age=view.findViewById(R.id.ag);
       weight=view.findViewById(R.id.wei);
       height=view.findViewById(R.id.hei);
       bmi=view.findViewById(R.id.mass);
       bfp=view.findViewById(R.id.fat);
       ffmi=view.findViewById(R.id.ffm);

       view.findViewById(R.id.ma).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               a=Integer.parseInt(age.getText().toString());
               w=Integer.parseInt(weight.getText().toString());
               h=Integer.parseInt(height.getText().toString());

               bmimf=(float) (w/((h/100)*(h/100)));

               bfpmf= (float) ((1.20*bmimf)+(0.23*a)-16.2);

               ffmimf=(float) (bmimf*(1-(bfpmf/100)));

           }
       });
       view.findViewById(R.id.fema).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               a=Integer.parseInt(age.getText().toString());
               w=Integer.parseInt(weight.getText().toString());
               h=Integer.parseInt(height.getText().toString());

               bmimf=(float) (w/((h/100)*(h/100)));

               bfpmf= (float) ((1.20*bmimf)+(0.23*a)-5.4);

               ffmimf=(float) (bmimf*(1-(bfpmf/100)));
           }
       });
       view.findViewById(R.id.res).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               bmi.setText(""+bmimf);
               bfp.setText(""+bfpmf);
               ffmi.setText(""+ffmimf);
           }
       });
       return view;
   }
}