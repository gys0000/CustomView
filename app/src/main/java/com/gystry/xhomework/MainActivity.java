package com.gystry.xhomework;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gystry.xhomework.widget.CircleTextView;

public class MainActivity extends AppCompatActivity {

//    @RequiresApi(api = Build.VERSION_CODES.O)
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
    }
}
