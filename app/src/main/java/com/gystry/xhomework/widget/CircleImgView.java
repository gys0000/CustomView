package com.gystry.xhomework.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class CircleImgView extends ImageView {

    private Paint paint;

    private Bitmap bitmap;
    private RectF rectF;
    private RectF bordRectF;

    public CircleImgView(Context context) {
        this(context, null);
    }

    public CircleImgView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xff046484);

        rectF = new RectF();

        bordRectF = new RectF();

        Drawable drawable = getDrawable();
        if (drawable != null) {
            setDrawable(drawable);
        }
    }

    /**
     * 将drawable转换成Bitmap
     *
     * @param drawable
     */
    private void setDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof NinePatchDrawable) {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                    drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
        }
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int min = Math.min(w, h);
        rectF.set((w - min) / 2.0f + 50, (h - min) / 2.0f + 50, (w - min) / 2.0f + min - 50, (h - min) / 2.0f + min - 50);

        bordRectF.set((w - min) / 2.0f, (h - min) / 2.0f, (w - min) / 2.0f + min, (h - min) / 2.0f + min);
    }

    @SuppressLint("DrawAllocation")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawOval(bordRectF, paint);
        if (bitmap != null) {
            int i = canvas.saveLayer(rectF, paint);
            canvas.drawOval(rectF, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, null, rectF, paint);
            paint.setXfermode(null);
            canvas.restoreToCount(i);
        }
    }
}
