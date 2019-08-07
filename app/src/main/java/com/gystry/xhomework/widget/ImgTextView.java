package com.gystry.xhomework.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.gystry.xhomework.R;
import com.gystry.xhomework.Utils;

public class ImgTextView extends View {

    private Bitmap bitmap;
    private final float IMG_SPAN = 300;
    private final float TEXT_SIZE = 68;
    private RectF rectF;
    private final String STR_CONTENT = "People are always talking about 'the problem of youth'. If there is one--which I take leave to doubt -- then it is " +
            "older people who create it, not the young themselves. Let us get down to fundamentals and agree that the young are after all human beings--people" +
            " just like their elders. There is only one difference between an old man and a young one: the young man has a glorious future before him and the " +
            "old one has a splendid future behind him: and maybe that is where the rub is.";
    private TextPaint textPaint;
    float[] mesaureWidth = new float[1];
    Paint.FontMetrics metrics = new Paint.FontMetrics();

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

        bitmap = Utils.getAvatar(context.getResources(), R.mipmap.ic_xiaoxin);

        rectF = new RectF();
        textPaint.getFontMetrics(metrics);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(w - bitmap.getWidth(), IMG_SPAN, w, IMG_SPAN + bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, null, rectF, null);

        //绘制文字
//        canvas.drawText(STR_CONTENT, 0, textPaint.getTextSize() + 20, textPaint);
        /*
         * 多行绘制
         * 参数1：文字内容
         * 参数2：画笔
         * 参数3：绘制的宽度范围，现在取的是view的宽度
         * 参数4：对齐方式，现在取得是默认
         * 参数5：两个文字的间隔是否加倍 1不加倍，大于1加倍增大，小于一加倍缩小
         * 参数6：固定值增加，
         * 参数7：上下要不要有额外空余
         */
//        StaticLayout staticLayout = new StaticLayout(STR_CONTENT, textPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
//        staticLayout.draw(canvas);
//        Log.e("ImgTextView", "onDraw: " + getWidth() + ":" + TEXT_SIZE);
        //measureForward 是否正向测量
        //绘制一行
        //测量一行的数字量
//        int textLineCount = textPaint.breakText(STR_CONTENT, true, getWidth(), mesaureWidth);
//        Log.e("ImgTextView", "onDraw: " + textLineCount);
//        canvas.drawText(STR_CONTENT, 0, textLineCount, 0, textPaint.getFontSpacing(), textPaint);

        Log.e("ImgTextView", "onDraw: " + metrics.ascent + ":" + metrics.descent + ":" + metrics.bottom + ":" + metrics.leading + ":" + metrics.top);
        Log.e("ImgTextView", "onDraw: " + textPaint.getFontSpacing() );
        float yOffset = textPaint.getFontSpacing();
        for (int textCount, count = 0; count < STR_CONTENT.length(); yOffset += textPaint.getFontSpacing(), count += textCount) {
            if (yOffset > rectF.top && yOffset - textPaint.getFontSpacing() < rectF.bottom) {
                textCount = textPaint.breakText(STR_CONTENT, count, STR_CONTENT.length(), true, getWidth() - bitmap.getWidth(), mesaureWidth);
            } else {
                textCount = textPaint.breakText(STR_CONTENT, count, STR_CONTENT.length(), true, getWidth(), mesaureWidth);
            }
            canvas.drawText(STR_CONTENT, count, count + textCount, 0, yOffset, textPaint);
        }
    }
}
