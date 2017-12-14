package com.example.jinmi.hencoderdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinmi on 2017/11/24 0024
 */

public class PaintBasicView extends View {
    private Paint paint = new Paint();

    public PaintBasicView(Context context) {
        super(context);
    }

    public PaintBasicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintBasicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(getContext().getResources().getColor(R.color.colorAccent));
        paint.setAntiAlias(true);
        canvas.drawColor(getContext().getResources().getColor(R.color.colorPrimary));
        canvas.drawCircle(0,0,200,paint);
        canvas.drawCircle(300,300,200,paint);
        /*canvas.drawLine(200,0,200,getHeight(),paint);
        canvas.drawLine(0,800,getWidth(),800,paint);
        canvas.drawLine(600,0,600,getHeight(),paint);
        canvas.drawLine(0,1200,getWidth(),1200,paint);*/
        //4个点确定一条直线
        float [] lines={200,0,200,getHeight(),0,800,getWidth(),800,600,0,600,getHeight(),0,1200,getWidth(),1200};
        canvas.drawLines(lines,0,16,paint);
        paint.setStrokeWidth(20);
        //设置点的形状square，butt方形,Round圆形
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(getWidth()/2,getHeight()/2,paint);
        float [] points={50,50,50,100,100,50,100,100};
      //  canvas.drawPoints(points,paint);
        //offset 跳过几个数开始绘制，count一共绘制几个数，2个数代表一个点
        canvas.drawPoints(points,1,6,paint);
        RectF rect=new RectF(250,250,750,500);
        canvas.drawOval(rect,paint);
        RectF rectF=new RectF(500,500,1000,750);
        //圆角矩形
       // canvas.drawRoundRect(rectF,100,50,paint);
        //画圆弧，rect的参数代表限制圆弧所在椭圆的边
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
        //sweepAngle是从起点开始画的角度,useCenter圆弧是否连接到圆心
        //canvas.drawArc(rect,-90,150,false,paint);
        canvas.drawArc(rect,-90,150,true,paint);
       // canvas.drawRect(200,800,600,1200,paint);
       /* paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(MainActivityKt.dp2px(getContext(), 5));
        paint.setTextSize(MainActivityKt.sp2px(getContext(), 18));
        canvas.drawColor(Color.parseColor("#88000000"));
        //  canvas.drawCircle(300,300,200,paint);
        // canvas.drawText("hello world",300,300,paint);
        //paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //paint.setStyle(Paint.Style.FILL);
        // canvas.drawRect(100,100,500,400,paint);
        //  canvas.drawRect(new RectF(100,100,500,400),paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        // canvas.drawPoint(200,300,paint);
        float[] points = {0, 0, 50, 50, 100, 100, 150, 150, 200, 200};
        // canvas.drawPoints(points,paint);
        //offset 跳过几个数开始绘制，count一共要绘制几个数
        //canvas.drawPoints(points,2,2,paint);
        // canvas.drawOval(50,50,450,450,paint);
        //canvas.drawOval(new RectF(50,50,650,450),paint);
        //  canvas.drawLine(100,100,500,500,paint);
        float[] lines = {50, 50, 250, 50, 150, 50, 150, 250, 50, 250, 250, 250};
        //canvas.drawLines(lines,paint);
        //canvas.drawRoundRect(new RectF(100,100,700,500),100,100,paint);
        *//*left, top, right, bottom 描述的是这个弧形所在的椭圆；
        startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        sweepAngle 是弧形划过的角度；
        useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。*//*
        RectF rectF = new RectF(100, 100, 500, 700);
        //canvas.drawArc(rectF, 90, 150, true, paint);
        //paint.setColor(Color.BLUE);
       // canvas.drawArc(rectF, 250, 60, true, paint);
        Path path=new Path();
      //  path.addCircle(300,300,200, Path.Direction.CW);
        //path.addCircle(500,300,200, Path.Direction.CCW);
        path.lineTo(300,300);
        path.rLineTo(300,0);
        path.rMoveTo(0,100);
        path.rLineTo(0,300);
        path.arcTo(rectF,-90,350,true);
       // path.close();
        canvas.drawPath(path,paint);*/
    }
}
