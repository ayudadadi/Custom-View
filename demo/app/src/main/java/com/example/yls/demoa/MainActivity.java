package com.example.yls.demoa;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity" ;
    private MyButton btn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Point start = new Point(100, 100);
                Point end = new Point(400, 600);
                ValueAnimator valueAnimator =  ValueAnimator.ofObject(new PointEvaluator(),
                        start, end);
                valueAnimator.setDuration(3000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                       Point point = (Point) valueAnimator.getAnimatedValue();
                       Log.e(TAG, "point  x = " + point.getX() + "  y = " + point.getY());
                       btn.setTranslationX(point.getX());
                       btn.setTranslationY(point.getY());
                       btn.requestLayout();
                    }
                });
                valueAnimator.start();
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*float currentX = btn.getTranslationX();
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn,
                        "translationX",currentX, 500);
                objectAnimator.setDuration(3000);
                objectAnimator.setRepeatCount(3);
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float value = (float) valueAnimator.getAnimatedValue();
                        btn.setTranslationY(value);
                    }
                });
                objectAnimator.start();*/

                MyColor start = new MyColor();
                start.red = 255;

                MyColor end = new MyColor();
                end.green = 255;

                ObjectAnimator objectAnimator = ObjectAnimator.ofObject(btn,
                        "myColor", new MyColorEvaluator(), start, end);
                objectAnimator.setDuration(5000);
                objectAnimator.start();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn,
                        "scaleX",1, 5);
                objectAnimator.setDuration(3000);
                objectAnimator.setRepeatCount(3);
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float value = (float) valueAnimator.getAnimatedValue();
                        btn.setScaleY(value);
                    }
                });
                objectAnimator.start();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn,
                        "rotation",0, 360);
                objectAnimator.setDuration(3000);
                objectAnimator.setRepeatCount(3);
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.start();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn,
                        "alpha",1,0,1);
                objectAnimator.setDuration(3000);
                objectAnimator.setRepeatCount(3);
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.start();*/
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        MainActivity.this, R.animator.alpha_anim);
                objectAnimator.setTarget(btn);
                objectAnimator.start();

            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(btn,
                        "alpha",1,0,1);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(btn,
                        "rotation",0, 360);
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(btn,
                        "scaleX",1, 5);
                float currentX = btn.getTranslationX();
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(btn,
                        "translationX",currentX, 500);
                animatorSet.play(objectAnimator3).with(objectAnimator2).before(objectAnimator1);
                animatorSet.setDuration(5000);
                animatorSet.start();
*/
                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(
                        MainActivity.this,
                        R.animator.anim_set);
                animatorSet.setTarget(btn);
                animatorSet.start();

            }
        });
    }
}

