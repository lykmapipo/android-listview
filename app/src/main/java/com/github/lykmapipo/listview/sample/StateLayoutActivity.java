package com.github.lykmapipo.listview.sample;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lykmapipo.listview.view.SimpleStateLayout;


public class StateLayoutActivity extends AppCompatActivity {
    private static final String TAG = StateLayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_layout);

        SimpleStateLayout sl = findViewById(R.id.sl);

        new Handler().postDelayed(sl::showContent, 1000);
        new Handler().postDelayed(sl::showState, 2000);
    }
}
