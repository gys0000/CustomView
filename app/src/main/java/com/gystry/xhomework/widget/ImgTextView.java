package com.gystry.xhomework.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.gystry.xhomework.R;

public class ImgTextView extends View {

    private Bitmap bitmap;
    private final float IMG_SPAN = 300;
    private final float TEXT_SIZE = 50;
    private RectF rectF;
    private final String STR_CONTENT = "People are always talking about 'the problem of youth'. If there is one--which I take leave to doubt -- then it is older people who create it, not the young themselves. Let us get down to fundamentals and agree that the young are after all human beings--people just like their elders. There is only one difference between an old man and a young one: the young man has a glorious future before him and the old one has a splendid future behind him: and maybe that is where the rub is.";
    private TextPaint textPaint;

    public ImgTextView(Context context) {
        this(context, null);
    }

    public ImgTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImgTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.parseColor("#261123"));
        textPaint.setTextSize(TEXT_SIZE);

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_xiaoxin);

        rectF = new RectF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(w - bitmap.getWidth(), IMG_SPAN, w, IMG_SPAN + bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(STR_CONTENT, 0, textPaint.getTextSize() + 20, textPaint);
        canvas.drawBitmap(bitmap, null, rectF, null);
    }
}
