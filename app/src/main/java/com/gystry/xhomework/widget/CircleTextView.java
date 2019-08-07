package com.gystry.xhomework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.gystry.xhomework.Utils;

public class CircleTextView extends View {

    private Paint mPaint;
    private TextPaint textPaint;
    private RectF rectF;
    private final float PADDING= Utils.dp2px(15);
    private float schedule;
    private final String STRCONTENT="abfg我和你";
    private Rect textRect;
    private Paint mLinePaint;
    private Paint.FontMetrics fontMetrics;

    public float getSchedule() {
        return schedule;
    }

    public void setSchedule(float schedule) {
        this.schedule = schedule;
        invalidate();
    }

    public CircleTextView(Context context) {
        this(context, null);
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(Utils.dp2px(18));
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(Utils.dp2px(2));
        mLinePaint.setStrokeCap(Paint.Cap.ROUND);

        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(Utils.dp2px(36));
        textPaint.setColor(Color.parseColor("#2b80e2"));
        //设置居中,这样设置就不会从文字的左下角绘制了
        textPaint.setTextAlign(Paint.Align.CENTER);

        rectF = new RectF();

        textRect = new Rect();

        fontMetrics = new Paint.FontMetrics();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int min = Math.min(w, h);
        Log.e("CIrcleTextView", "onSizeChanged: "+w+":"+min+":"+h);
        rectF.set(PADDING+(w-min)/2f,PADDING+(h-min)/2f,min-PADDING+(w-min)/2f,min-PADDING+(h-min)/2f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,getHeight()/2f,getWidth(),getHeight()/2f,mLinePaint);
        canvas.drawLine(getWidth()/2f,0,getWidth()/2f,getHeight(),mLinePaint);

        mPaint.setColor(Color.parseColor("#646d71"));
        canvas.drawOval(rectF,mPaint);

        mPaint.setColor(Color.parseColor("#e24b6f"));
        canvas.drawArc(rectF,-90,schedule*360,false,mPaint);

        //第一种测量文字的方法 textPaint.getTextBounds
        //这种方法在文字变化的时候会来回跳跃，比如abcdef和abcdrfg,上下居中的位置是不一样的。
//        textPaint.getTextBounds(STRCONTENT,0,STRCONTENT.length(),textRect);
//        float offset = (textRect.top + textRect.bottom)/2f;//两个点的中心就是两个点的值相加除以2

        //第二种方法测量文字的方法  textPaint.getFontMetrics
        //这种方法不会上下跳动
        textPaint.getFontMetrics(fontMetrics);//获取文字属性的边界
        float offset = (fontMetrics.descent + fontMetrics.ascent) / 2f;

        canvas.drawText(STRCONTENT,getWidth()/2f,getHeight()/2f-offset,textPaint);
    }
}
