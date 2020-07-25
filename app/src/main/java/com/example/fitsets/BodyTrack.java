package com.example.fitsets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fitsets.ui.main.BodyTrackFragment;

public class BodyTrack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body_track_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BodyTrackFragment.newInstance())
                    .commitNow();
        }
    }
}