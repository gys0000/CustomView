package com.gystry.xhomework;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Utils {

    public static Bitmap getAvatar(Resources resources, int resId) {
        return getAvatar(resources, resId, 0);
    }

    public static Bitmap getAvatar(Resources resources, int resId, int width) {
        if (width != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, resId, options);
            options.inJustDecodeBounds = false;
            options.inDensity = options.outWidth;
            options.inTargetDensity = width;
            return BitmapFactory.decodeResource(resources, resId, options);
        } else {
            return BitmapFactory.decodeResource(resources, resId);
        }

    }
}
