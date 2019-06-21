package com.example.yls.demoa;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by yls on 2019/5/8.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    private MyColor color;

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyColor getMyColor() {
        return color;
    }

    public void setMyColor(MyColor color) {
        this.color = color;
        this.setBackgroundColor(Color.argb(255, color.red, color.green, color.blue));
    }
}
