package com.example.jinmi.hencoderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinmi on 2017/12/22 0022.
 */

public class PaintBasicView4 extends View {
    Paint paint = new Paint();

    public PaintBasicView4(Context context) {
        super(context);
    }

    public PaintBasicView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintBasicView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        Rect rect = new Rect(100, 100, 1000, 2000);
        canvas.save();
        canvas.clipRect(rect);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();
    }
}
