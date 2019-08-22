package com.gystry.xhomework;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CamreaView viewById = (CamreaView) findViewById(R.id.progress_circular);
//        ObjectAnimator bottomFlipAnimator = ObjectAnimator.ofFloat(viewById, "bottomFlip", 30f);
//        bottomFlipAnimator.setDuration(1000);
//
//        ObjectAnimator topFlipAnimator = ObjectAnimator.ofFloat(viewById, "topFlip", -30f);
//        topFlipAnimator.setDuration(1000);
//        topFlipAnimator.setStartDelay(200);
//
//        ObjectAnimator rotationFlipAnimator = ObjectAnimator.ofFloat(viewById, "rotationFlip", 270f);
//        rotationFlipAnimator.setDuration(1000);
//        rotationFlipAnimator.setStartDelay(200);
//
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playSequentially(bottomFlipAnimator, rotationFlipAnimator, topFlipAnimator);
//        animatorSet.setStartDelay(500);
//        animatorSet.reverse();
//        animatorSet.start();
//        CircleTextView viewById = (CircleTextView) findViewById(R.id.progress_circular);
//        ObjectAnimator schedule = ObjectAnimator.ofFloat(viewById, "schedule", 0.45f);
//        schedule.setDuration(1000);
//        schedule.setStartDelay(500);
//        schedule.start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//              while (true){
//                  Log.e("XHOMEWORK-MainActivity", "run: 1111111111111111" );
//              }
//            }
//        }).start();

        HashMap map=new HashMap();
//        map.get()
        map.put("li","yaowen");
        Object put = map.put("lyi", "yaowen11");
        Log.e("MainActivity", "onCreate: "+ put);
        int size = map.size();
        Log.e("MainActivity", "onCreate: "+size);
    }
}