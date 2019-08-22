package com.gystry.xhomework.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.gystry.xhomework.Utils;

import java.util.Random;

public class ColorTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint mPaint;
    public final int[] COLORS={Color.parseColor("#E91E63"),
            Color.parseColor("#673AB7"),
            Color.parseColor("#3F51B5"),
            Color.parseColor("#2196F3"),
            Color.parseColor("#009688"),
            Color.parseColor("#FF9800"),
            Color.parseColor("#FF5722"),
            Color.parseColor("#795548"),
    };
    private final int[]TEXT_SIZES={
      16,2,28
    };
    private Random random;
    private static final int CORNER_RADIUS = (int) Utils.dp2px(4);
    private static final int X_PADDING = (int) Utils.dp2px(16);
    private static final int Y_PADDING = (int) Utils.dp2px(8);

    public ColorTextView(Context context) {
        this(context,null);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs) {
      this(context, attrs,0);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        random = new Random();

        setTextColor(Color.WHITE);
        setTextSize(TEXT_SIZES[random.nextInt(3)]);
        mPaint.setColor(COLORS[random.nextInt(COLORS.length)]);
        setPadding(X_PADDING,Y_PADDING,X_PADDING,Y_PADDING);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(0,0,getWidth(),getHeight(),CORNER_RADIUS,CORNER_RADIUS,mPaint);
        super.onDraw(canvas);
    }
}
