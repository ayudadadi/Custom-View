package com.example.yls.demoa;

import android.animation.TypeEvaluator;

/**
 * Created by yls on 2019/5/8.
 */

public class MyColorEvaluator implements TypeEvaluator<MyColor> {
    @Override
    public MyColor evaluate(float fraction, MyColor start, MyColor end) {
        int red = (int) (start.red + fraction * (end.red - start.red));
        int blue = (int) (start.blue + fraction * (end.blue - start.blue));
        int green = (int) (start.green + fraction * (end.green - start.green));
        MyColor myColor = new MyColor();
        myColor.red = red;
        myColor.blue = blue;
        myColor.green = green;
        return myColor;
    }
}
