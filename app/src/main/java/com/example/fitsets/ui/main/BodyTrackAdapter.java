package com.example.fitsets.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fitsets.R;
import com.example.fitsets.ui.DatabaseHelper;
import com.example.fitsets.ui.model.BodyTrack;

import java.util.ArrayList;

public class BodyTrackAdapter extends BaseAdapter {
    Context context;
    ArrayList<BodyTrack> partnam;
    DatabaseHelper databaseHelper;
    public BodyTrackAdapter(Context context, ArrayList<BodyTrack> partnam){
        this.context=context;
        this.partnam=partnam;
    }

    @Override
    public int getCount() {
        return this.partnam.size();
    }

    @Override
    public Object getItem(int position) {
        return partnam.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.listview_bodytrack,null);

        TextView partname=(TextView) convertView.findViewById(R.id.part_name);
        TextView size=(TextView) convertView.findViewById(R.id.size);
        TextView time_min=(TextView) convertView.findViewById(R.id.bt_time);
        TextView date_current=(TextView) convertView.findViewById(R.id.bt_date);

        final BodyTrack bodyTrack=partnam.get(position);

        partname.setText(bodyTrack.getPartname());
        size.setText(bodyTrack.getSize());
        time_min.setText(bodyTrack.getTime());
        date_current.setText(bodyTrack.getDte());

        return convertView;
    }
}
