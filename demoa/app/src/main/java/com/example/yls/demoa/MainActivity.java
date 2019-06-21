package com.example.yls.demoa;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnStart;
    private ImageView ivCat;
    private Button btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnim = findViewById(R.id.btn_anim);
        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startPropertyAnimWithJava();
                startPropertyAnimWithXML();
            }
        });

        btnStart = findViewById(R.id.btn_start);
        ivCat = findViewById(R.id.iv_cat);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startRotateWithJava();
//                startRotateWithXML();
//                startAnimationSetWithJava();
                startAnimationSetWithXML();
            }
        });
    }

    private void startPropertyAnimWithXML() {
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(
                MainActivity.this, R.animator.set_animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) valueAnimator.getAnimatedValue();
                Log.e(TAG, "value = " + value);
                btnAnim.getLayoutParams().width = value;
                btnAnim.getLayoutParams().height = value;
                btnAnim.setText("属性动画" + value);
                btnAnim.setBackgroundColor(Color.argb(255, value/2, 0, 0));
                btnAnim.requestLayout();
            }
        });
        valueAnimator.start();
    }

    private void startPropertyAnimWithJava() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(
                btnAnim.getLayoutParams().width, 500);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) valueAnimator.getAnimatedValue();
                Log.e(TAG, "value = " + value);
                btnAnim.getLayoutParams().width = value;
                btnAnim.requestLayout();
            }
        });
        valueAnimator.setRepeatCount(5);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }

    private void startAnimationSetWithXML() {
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.animation_set);
        ivCat.startAnimation(animationSet);
    }

    private void startAnimationSetWithJava() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 400, 0, 600);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                180, 180);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 3, 1, 3,
                180, 180);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(3000);
        animationSet.setRepeatCount(5);
        animationSet.setRepeatMode(Animation.REVERSE);
        ivCat.startAnimation(animationSet);
    }

    private void startRotateWithXML() {
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(
                MainActivity.this, R.anim.rotate);
        ivCat.startAnimation(rotateAnimation);
    }

    private void startRotateWithJava() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                180, 180);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        ivCat.startAnimation(rotateAnimation);
    }
}
