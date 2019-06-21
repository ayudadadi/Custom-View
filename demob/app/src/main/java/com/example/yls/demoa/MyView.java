package com.example.yls.demoa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;



public class MyView extends View {
    private Paint paint = new Paint();
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
    }

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cat);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        Matrix matrix =  new Matrix();
        matrix.setRotate(90, 225, 225);
        canvas.drawBitmap(bitmap, matrix, paint);
        matrix.setRotate(180, 225, 225);
        canvas.drawBitmap(bitmap, matrix, paint);
        matrix.setRotate(270, 225, 225);
        canvas.drawBitmap(bitmap, matrix, paint);




        /*Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dog);
       canvas.drawBitmap(bitmap, 0, 0, paint);

        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1);
        matrix.postTranslate(450, 0);
        canvas.drawBitmap(bitmap, matrix, paint);

        Matrix matrix2 = new Matrix();
        matrix2.setScale(1, -1);
        matrix2.postTranslate(0, 297);
        canvas.drawBitmap(bitmap, matrix2, paint);

        Matrix matrix3 = new Matrix();
        matrix3.setScale(-1, -1);
        matrix3.postTranslate(450, 297);
        canvas.drawBitmap(bitmap, matrix3, paint);*/

//        canvas.drawColor(Color.BLUE);
//        canvas.drawPoint(100, 100, paint);
//        canvas.drawLine(100, 100, 300, 500, paint);
//        canvas.drawRect(100, 100, 300, 500, paint);
//        canvas.drawRoundRect(100, 100, 300, 300, 50, 50, paint);
//        canvas.drawCircle(200, 200, 100, paint);
//        canvas.drawArc(100,100, 400, 400, 225, 90,
//                false,paint);
//        canvas.drawText("软件", 100, 100, paint);
       /* Point a = new Point(0, 100);
        Point b = new Point(300, 100);
        Point c = new Point(50, 250);
        Point d = new Point(250, 250);
        Point e = new Point(150, 0);
        Path path = new Path();
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(e.x, e.y);
        path.lineTo(d.x, d.y);
        path.lineTo(a.x, a.y);
        canvas.drawPath(path, paint);
        canvas.drawText("闪闪的红星",80, 300, paint);*/
    }
}

