package com.example.yls.demoa;

import android.animation.TypeEvaluator;

/**
 * Created by yls on 2019/5/8.
 */

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int x = (int) (startValue.getX() + fraction*(endValue.getX() -startValue.getX()));
        int y = (int) (startValue.getY() + fraction * (endValue.getY() - startValue.getY()));
        return new Point(x, y);
    }
}
