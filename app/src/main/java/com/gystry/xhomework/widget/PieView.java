package com.gystry.xhomework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PieView extends View {

    private Paint paint;
    private final int[] pieSis = {13, 44, 10, 33};
    private final int[] pieColors = {0xff046484, 0xffFBE106, 0xff2FAA06, 0xffB1069B};
    private RectF rectF;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);

        rectF = new RectF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int min = Math.min(w, h);
        rectF.set((w - min) / 2.0f+50, (h - min) / 2.0f+50, (w - min) / 2.0f + min-50, (h - min) / 2.0f + min-50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float currentAngle = 0;
        for (int i = 0; i < pieSis.length; i++) {
            if (i == 2) {
                canvas.save();
                paint.setColor(pieColors[i]);
                Log.e("PieView", "onDraw: "+(float) (Math.cos(Math.toRadians(currentAngle+(360 * (pieSis[i] / 100.0f)/2)))*80)
                        +":"+(float) (Math.sin(Math.toRadians(currentAngle+(360 * (pieSis[i] / 100.0f)/2)))*80.0f));
                canvas.translate((float) (Math.cos(Math.toRadians(currentAngle+(360 * (pieSis[i] / 100.0f)/2)))*100.0f),(float) (Math.sin(Math.toRadians(currentAngle+(360 * (pieSis[i] / 100.0f)/2)))*100.0f));
                canvas.drawArc(rectF, currentAngle, (360 * (pieSis[i] / 100.0f)), true, paint);
                currentAngle += (360 * (pieSis[i] / 100.0f));
                canvas.restore();
            } else {
                paint.setColor(pieColors[i]);
                canvas.drawArc(rectF, currentAngle, (360 * (pieSis[i] / 100.0f)), true, paint);
                currentAngle += (360 * (pieSis[i] / 100.0f));
            }
        }
    }
}
