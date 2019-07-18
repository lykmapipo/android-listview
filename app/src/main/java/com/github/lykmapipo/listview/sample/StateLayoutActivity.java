package com.github.lykmapipo.listview.sample;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lykmapipo.listview.view.StateLayout;


public class StateLayoutActivity extends AppCompatActivity {
    private static final String TAG = StateLayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_layout);

        StateLayout sl = findViewById(R.id.sl);

        new Handler().postDelayed(() -> {
            sl.showEmpty(empty -> {
                Toast.makeText(this, "Empty Retry Clicked", Toast.LENGTH_SHORT).show();
                sl.showError(error -> {
                    Toast.makeText(this, "Error Retry Clicked", Toast.LENGTH_SHORT).show();
                    sl.showOffline(offline -> {
                        Toast.makeText(this, "Offline Retry Clicked", Toast.LENGTH_SHORT).show();
                        sl.showContent();
                    });
                });
            });
        }, 1000);
    }
}
