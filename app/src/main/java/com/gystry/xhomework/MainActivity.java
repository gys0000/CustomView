package com.gystry.xhomework;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gystry.xhomework.widget.CircleTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CircleTextView viewById = (CircleTextView) findViewById(R.id.progress_circular);
//        ObjectAnimator schedule = ObjectAnimator.ofFloat(viewById, "schedule", 0.45f);
//        schedule.setDuration(1000);
//        schedule.setStartDelay(500);
//        schedule.start();
    }
}