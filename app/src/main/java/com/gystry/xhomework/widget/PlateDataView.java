package com.gystry.xhomework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PlateDataView extends View {

    private Paint mPaint;
    private Path ovalPath;
    private static final int SANGLE = 120;
    private static final int STROKE_WIDTH = 8;
    private Paint mScalePaint;
    private RectF rectF;
    private Path dashPath;
    private static final int POINTER_LENGTH = 300;

    private static final int SCALE_NUM = 20;
    private PathMeasure pathMeasure;

    public PlateDataView(Context context) {
        this(context, null);
    }

    public PlateDataView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlateDataView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xffb0f566);
        mPaint.setStrokeWidth(STROKE_WIDTH);

        mScalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mScalePaint.setDither(true);
        mScalePaint.setStyle(Paint.Style.STROKE);
        mScalePaint.setColor(0xffb0f566);
        mScalePaint.setStrokeWidth(STROKE_WIDTH);


        ovalPath = new Path();

        dashPath = new Path();

        rectF = new RectF();

        //在path有实际的值之后才能设置进去，才能有数据
        pathMeasure = new PathMeasure();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int min = Math.min(w, h);

        rectF.set((w - min) / 2.0f, (h - min) / 2.0f, (w - min) / 2.0f + min, (h - min) / 2.0f + min);

        ovalPath.addArc(rectF, 90 + SANGLE / 2, 360 - SANGLE);
        pathMeasure.setPath(ovalPath, false);
        Log.e("PlateDataView", "onSizeChanged: " + min + ":" + w + ":" + h + ":" + pathMeasure.getLength());


        dashPath.addRect(0, 0, 5, 18, Path.Direction.CCW); //right 是刻度的厚度，bottom是长度


        mScalePaint.setPathEffect(new PathDashPathEffect(dashPath, (pathMeasure.getLength() - 5) / SCALE_NUM, 0, PathDashPathEffect.Style.ROTATE));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画外围的圆弧
        canvas.drawPath(ovalPath, mPaint);
        //画刻度
        canvas.drawPath(ovalPath, mScalePaint);



        Log.e("PlateDataView", "onDraw: -----"+Math.cos(Math.toRadians(90+SANGLE/2.0f)));
        Log.e("PlateDataView", "onDraw: "+Math.toRadians(180));
        Log.e("PlateDataView", "onDraw: "+Math.cos(Math.toRadians(180)));

        canvas.drawLine(getWidth() / 2.0f, getHeight() / 2.0f, (float) (getWidth() / 2.0f+Math.cos(Math.toRadians(toMark(5)))*POINTER_LENGTH),
                (float) (getHeight() / 2.0f + Math.sin(Math.toRadians(toMark(5)))*POINTER_LENGTH), mPaint);
    }

    private float toMark(int num){

        return 90+SANGLE/2.0f+((360-SANGLE)/SCALE_NUM)*num;
    }
}
