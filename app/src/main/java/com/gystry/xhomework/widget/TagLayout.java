package com.gystry.xhomework.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class TagLayout extends ViewGroup {
    public TagLayout(Context context) {
        this(context, null);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.layout(0, 0, (r - l) / 2, (b - t) / 2);
        }
        new Thread(runnable).start();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    int arg1 = msg.arg1;
                    String obj = (String) msg.obj;
                    Log.e("Taglayout", "handleMessage: " + arg1 + ":" + obj);
                    break;
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                Message message = handler.obtainMessage(0);
                message.arg1 = 112;
                message.obj = "偏偏你不知";
                handler.sendMessage(message);
            }
        }
    };
}
