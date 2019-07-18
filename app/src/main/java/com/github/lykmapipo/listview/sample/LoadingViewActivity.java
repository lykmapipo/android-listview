package com.github.lykmapipo.listview.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import com.github.lykmapipo.listview.view.LoadingView;


public class LoadingViewActivity extends AppCompatActivity {
    private static final String TAG = LoadingViewActivity.class.getSimpleName();
    private LoadingView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_view);

        LoadingView lv = findViewById(R.id.lv);

        ContentLoadingProgressBar pb = lv.getProgressBar();

    }
}
