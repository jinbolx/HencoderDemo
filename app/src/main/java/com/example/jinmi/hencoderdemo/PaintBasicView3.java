package com.example.jinmi.hencoderdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by jinmi on 2017/12/15 0015.
 */

public class PaintBasicView3 extends View {
    private Paint paint = new Paint();

    public PaintBasicView3(Context context) {
        super(context);
    }

    public PaintBasicView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintBasicView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(6);
        paint.setTextSize(60);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawColor(Color.BLACK);
        String text = "hello world,hello everyone";
        //删除线
        // paint.setStrikeThruText(true);
        //下划线
        //paint.setUnderlineText(true);
        //文字倾斜度
        //paint.setTextSkewX(-0.5f);
        paint.setTextSkewX(-0.7f);
        //paint.setTextAlign(Paint.Align.CENTER);
       // canvas.drawText(text, 200, 100, paint);
        canvas.drawText(text,300,200,paint);
        Path path=new Path();
        path.moveTo(300,300);
        path.rLineTo(100,200);
        path.rLineTo(300,-200);
        path.rLineTo(100,400);
        paint.setStrokeCap(Paint.Cap.ROUND);
        //paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawPath(path,paint);
        canvas.drawTextOnPath(text,path,100,50,paint);
        String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        canvas.drawText(text1,50,800,paint);
        TextPaint textPaint=new TextPaint();
        textPaint.setTextSize(40);
        textPaint.setColor(Color.WHITE);
        textPaint.setFakeBoldText(true);
        textPaint.setStrikeThruText(true);
        textPaint.setUnderlineText(true);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextScaleX(2);
        StaticLayout staticLayout=new StaticLayout(text1,textPaint,600, Layout.Alignment.ALIGN_CENTER,1,0,true);
        StaticLayout staticLayout1=new StaticLayout(text2,textPaint,600, Layout.Alignment.ALIGN_CENTER,1,0,true);
        canvas.save();
        canvas.translate(50,100);
        staticLayout.draw(canvas);
        canvas.translate(0,200);
        staticLayout1.draw(canvas);
        canvas.restore();
        canvas.drawText(text,100,1000,paint);
        canvas.drawText(text,100,1000+paint.getFontSpacing(),paint);
        canvas.drawText(text,100,1000+2*paint.getFontSpacing(),paint);
        Rect bounds=new Rect();
        paint.getTextBounds(text,0,text.length(),bounds);
        Log.i("PaintBasic","left: "+bounds.left+" right: "+bounds.right+" top: "+bounds.top+" bottom: "+bounds.bottom);
        bounds.left+=100;
        bounds.top+=1000;
        bounds.right+=100;
        bounds.bottom+=1000;
        canvas.drawRect(bounds,paint);
        float textWidth=paint.measureText(text);
        canvas.drawLine(100,1000,100+textWidth,1000,paint);
        int measuredCount;
        float[] measuredWidth={0};
        measuredCount=paint.breakText(text,0,text.length(),true,300,measuredWidth);
        canvas.drawText(text,0,measuredCount,150,1300,paint);
    /*    //测量文字的宽度
        float textWidth=paint.measureText(text);
       // canvas.drawText(text, 200, 100 + paint.getFontSpacing(), paint);
        //canvas.drawLine(200,100,200+textWidth,100,paint);
        Rect bound=new Rect();
        //获取文字的显示范围
        paint.getTextBounds(text,0,text.length(),bound);
        bound.left+=200;
        bound.top+=100+paint.getFontSpacing();
        bound.right+=200;
        bound.bottom+=100+paint.getFontSpacing();
        canvas.drawRect(bound,paint);
        Path path = new Path();
        path.moveTo(200, 200);
        path.rLineTo(300, 200a);
        path.rLineTo(200, -100);
        path.rLineTo(300, 300);
        //  canvas.drawPath(path, paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(60);
        textPaint.setColor(Color.WHITE);
        String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        //hoffset相对于path的水平偏移量，vOffset相对于path的垂直偏移量
        paint.setFakeBoldText(true);
        paint.setTypeface(Typeface.SANS_SERIF);*/
      //  canvas.drawTextOnPath(text, path, 20f, 20f, paint);
      /*  StaticLayout staticLayout=new StaticLayout(text1,textPaint,600,StaticLayout.Alignment.ALIGN_NORMAL
        ,1,0,true);
        StaticLayout staticLayout2=new StaticLayout(text2,textPaint,600,StaticLayout.Alignment.ALIGN_NORMAL
                ,1,0,true);
        canvas.save();
        canvas.translate(50,100);
        staticLayout.draw(canvas);
        canvas.translate(0,300);
        textPaint.setTypeface(Typeface.SANS_SERIF);
        staticLayout2.draw(canvas);
        canvas.restore();*/
    }
}
