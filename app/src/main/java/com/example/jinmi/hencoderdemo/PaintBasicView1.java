package com.example.jinmi.hencoderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinmi on 2017/11/24 0024
 */

public class PaintBasicView1 extends View {
    private Paint paint = new Paint();

    public PaintBasicView1(Context context) {
        super(context);
    }

    public PaintBasicView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintBasicView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        canvas.drawCircle(0, 0, 200, paint);
        canvas.drawCircle(300, 300, 200, paint);
        /*canvas.drawLine(200,0,200,getHeight(),paint);
        canvas.drawLine(0,800,getWidth(),800,paint);
        canvas.drawLine(600,0,600,getHeight(),paint);
        canvas.drawLine(0,1200,getWidth(),1200,paint);*/
        //4个点确定一条直线
        float[] lines = {200, 0, 200, getHeight(), 0, 800, getWidth(), 800, 600, 0, 600, getHeight(), 0, 1200, getWidth(), 1200};
        canvas.drawLines(lines, 0, 16, paint);
        paint.setStrokeWidth(20);
        //设置点的形状square，butt方形,Round圆形
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(getWidth() / 2, getHeight() / 2, paint);
        float[] points = {50, 50, 50, 100, 100, 50, 100, 100};
        //  canvas.drawPoints(points,paint);
        //offset 跳过几个数开始绘制，count一共绘制几个数，2个数代表一个点
        canvas.drawPoints(points, 1, 6, paint);
        RectF rect = new RectF(250, 250, 750, 500);
        canvas.drawOval(rect, paint);
        RectF rectF = new RectF(500, 500, 1000, 750);
        //圆角矩形
        // canvas.drawRoundRect(rectF,100,50,paint);
        //画扇形，rect的参数代表限制扇形所在椭圆的边
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
        //sweepAngle是从起点开始画的角度,useCenter圆弧是否连接到圆心
        //canvas.drawArc(rect,-90,150,false,paint);
        canvas.drawArc(rect, -90, 150, true, paint);
        Path path = new Path();
        RectF rectF2 = new RectF(200, 200, 400, 400);
        path.addArc(rectF2, -225, 225);
        RectF rectF3 = new RectF(400, 200, 600, 400);
        path.arcTo(rectF3, -180, 225, false);
        path.lineTo(400, 542);
        paint.setColor(Color.rgb(0, 0, 0));
        canvas.drawPath(path, paint);
        Path path1 = new Path();
        //CW顺时针，CCW逆时针
        path1.addCircle(300, 900, 200, Path.Direction.CCW);
        path1.addCircle(500, 900, 200, Path.Direction.CW);

        /*
        Even_ODD 奇偶原则：从平面中任意一点向任意方向射出一条射线，与图形相交的次数为奇数这个点被认为在图形内
        要被涂色，为偶数认为在图形外，不涂色（即交叉填充）；INVERSE_EVEN_ODD与其相反
        WINDING（非零环绕数原则）需要所有的线条都有绘制方向，以0为初始值从平面中的点向任意方向射出一条射线，对于图形和
        射线所有的交点，正时针加一，逆时针减一所有交点算上，最后结果不为0的都被认为是在图形内部是要被涂色的区域，
        为0认为是在图形外部是不被涂色的区域；INVERSE_WINDING与其相反
        * */
        path1.setFillType(Path.FillType.WINDING);
        //lineTo某个坐标，rLineTo相对的位置
        path1.lineTo(100, 100);
        path1.rLineTo(100, 0);
        path1.moveTo(500, 500);
        path1.rLineTo(200, 0);
        path1.rMoveTo(0, 100);
        path1.rLineTo(-200, 0);
        RectF rectF4 = new RectF(500, 100, 800, 700);
        //arcTo画圆弧不画扇形,forceMoveTo true强制移动到当前位置不留下痕迹
        //path1.arcTo(rectF4,-90,150,true);
        // path1.arcTo(rectF4,-90,150);
        //addArc是arcTo的简化版默认forceMoveTo 为true
        path1.addArc(rectF4, -90, 150);
        //关闭当前图形，即由当前位置向起点画一条线
        path1.close();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Path path2 = new Path();
        path2.moveTo(100, 100);
        path2.lineTo(200, 100);
        path2.lineTo(150, 150);
        canvas.drawPath(path1, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        canvas.drawBitmap(bitmap, 200, 100, paint);
        String text="hello world";
        paint.setTextSize(40);
        paint.setColor(Color.WHITE);
        canvas.drawText(text,200,1000,paint);
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
