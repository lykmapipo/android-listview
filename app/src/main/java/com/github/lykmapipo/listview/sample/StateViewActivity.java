package com.github.lykmapipo.listview.sample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.github.lykmapipo.listview.view.StateView;
import com.google.android.material.button.MaterialButton;


public class StateViewActivity extends AppCompatActivity {
    private static final String TAG = StateViewActivity.class.getSimpleName();
    private StateView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_view);

        sv = findViewById(R.id.sv);

        AppCompatTextView title = sv.getTitle();
        AppCompatTextView message = sv.getMessage();
        AppCompatImageView image = sv.getImage();

        MaterialButton action = sv.getAction();
        action.setVisibility(View.VISIBLE);

    }
}
