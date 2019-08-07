package com.gystry.xhomework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyTextView extends View {

    private Paint paint;
    private Paint linePaint;
    private Rect textBound;
    private final String COMMEND_TEXT = "abcdefg";
    private Paint.FontMetrics matric;

    public MyTextView(Context context) {
        this(context, null);

    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100);
        paint.setColor(0xffe20f2b);
        //设置居中,这样设置就不会从文字的左下角绘制了
        paint.setTextAlign(Paint.Align.CENTER);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(1);
        linePaint.setDither(true);
        linePaint.setColor(0xff2b80e2);

        textBound = new Rect();

        matric = new Paint.FontMetrics();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, getWidth(), getHeight(), linePaint);
        canvas.drawLine(0, getHeight() / 2f, getWidth(), getHeight() / 2f, linePaint);//绘制中轴线横线
        canvas.drawLine(getWidth() / 2f, 0, getWidth() / 2f, getHeight(), linePaint);//绘制中轴线竖线

        paint.setStyle(Paint.Style.FILL);

        //这种方法在文字变化的时候会来回跳跃，比如abcdef和abcdrfg,上下居中的位置是不一样的。
        paint.getTextBounds(COMMEND_TEXT, 0, COMMEND_TEXT.length(), textBound);
        float offset = (textBound.top + textBound.bottom) / 2f;//两个点的中心就是两个点的值相加除以2

//        paint.getFontMetrics(matric);//获取文字的边界属性
//        float offset=(matric.ascent+matric.descent)/2f;//这种方法在文字变化的时候，不会来回跳跃

        canvas.drawText(COMMEND_TEXT, getWidth() / 2f, getHeight() / 2f - offset, paint);
        Log.e("MyTextView", "onDraw: " + paint.getFontSpacing());




    }
}
