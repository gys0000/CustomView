package com.gystry.xhomework.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gystry.xhomework.R;
import com.gystry.xhomework.Utils;

public class CamreaView extends View {
    private Bitmap bitmap;
    private final float IMG_SPAN = 300;
    private Paint mPaint;
    private Camera camera;

    public CamreaView(Context context) {
        this(context, null);
    }

    public CamreaView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CamreaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = Utils.getAvatar(getResources(), R.mipmap.ic_xiaoxin);
        camera = new Camera();

        camera.rotateX(60);
        camera.setLocation(0, 0, -4*getResources().getDisplayMetrics().density);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //切割
//        canvas.clipRect(0,0,IMG_SPAN+bitmap.getWidth()/2,IMG_SPAN+bitmap.getHeight()/2);

        //camera
        //上半部分
        canvas.save();
        canvas.translate(IMG_SPAN + bitmap.getWidth() / 2f, IMG_SPAN + bitmap.getHeight() / 2f);
        canvas.rotate(-30);
        canvas.clipRect(-bitmap.getWidth(),-bitmap.getHeight(),bitmap.getWidth(),0);
        canvas.rotate(30);
        canvas.translate(-(IMG_SPAN + bitmap.getWidth() / 2f), -(IMG_SPAN + bitmap.getHeight() / 2f));
        canvas.drawBitmap(bitmap, IMG_SPAN, IMG_SPAN, null);
        canvas.restore();
        //下半部分
        canvas.save();
        canvas.translate(IMG_SPAN + bitmap.getWidth() / 2f, IMG_SPAN + bitmap.getHeight() / 2f);
        canvas.rotate(-30);
        camera.applyToCanvas(canvas);//应用camera的角度旋转
        canvas.clipRect(-bitmap.getWidth(),0,bitmap.getWidth(),bitmap.getHeight());
        canvas.rotate(30);
        canvas.translate(-(IMG_SPAN + bitmap.getWidth() / 2f), -(IMG_SPAN + bitmap.getHeight() / 2f));
        canvas.drawBitmap(bitmap, IMG_SPAN, IMG_SPAN, null);
        canvas.restore();
    }
}
