package com.github.lykmapipo.listview.sample;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lykmapipo.listview.view.StateLayout;


public class StateLayoutActivity extends AppCompatActivity {
    private static final String TAG = StateLayoutActivity.class.getSimpleName();
    private StateLayout slList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_layout);

        slList = findViewById(R.id.slList);

        new Handler().postDelayed(() -> slList.setState(StateLayout.VIEW_ERROR), 1000);
    }
}
