package com.example.jinmi.hencoderdemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by jinmi on 2017/12/15 0015.
 */
class PaintBasicView2:View {
    private val paint=Paint()
    constructor(context: Context):super(context)
    constructor(context: Context,attributes: AttributeSet):super(context,attributes)
    constructor(context: Context,attributes: AttributeSet,defStyleAttr:Int):super(context,attributes,defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        //setLayerType(View.LAYER_TYPE_HARDWARE,null)
       // paint.color= Color.BLACK
        // tile着色规则:CLAMP端点之外延续端点处的颜色，MIRROR 镜像模式,REPEAT重复模式
        val shader=LinearGradient(100f,100f,500f,500f,Color.parseColor("#E91E63")
        ,Color.parseColor("#2196F3"),Shader.TileMode.REPEAT)
        //辐射渐变，由中心向周围辐射状渐变
        val rShader=RadialGradient(500f,500f,200f,Color.parseColor("#E91E63")
                ,Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)
       //扫描渐变
        val  sweepShader=SweepGradient(500f,500f,Color.parseColor("#E91E63")
                ,Color.parseColor("#2196F3"))
        val bitmap=BitmapFactory.decodeResource(resources,R.drawable.f)
        val bitmap2=BitmapFactory.decodeResource(resources,R.drawable.g)
        val bitmapc=BitmapFactory.decodeResource(resources,R.drawable.c)
         val bitmapShaderC=BitmapShader(bitmapc,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        val bitmap3=Bitmap.createBitmap(bitmap2,0,0,200,200)
        val bitmapShader=BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        val bitmapShader2=BitmapShader(bitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        val composeShader=ComposeShader(bitmapShader,bitmapShader2,PorterDuff.Mode.SRC_OVER)
        paint.shader=composeShader
        paint.isAntiAlias=true
        val lightingColorFilter:ColorFilter=LightingColorFilter(0x00ffff,0x0000ff)
        val porterFilter=PorterDuffColorFilter(Color.RED,PorterDuff.Mode.SRC_OVER)
       val matrix=ColorMatrix()
        matrix.setSaturation(0.5f)
        val colorMatrixColorFilter=ColorMatrixColorFilter(matrix)
       // paint.colorFilter = colorMatrixColorFilter
        canvas?.drawColor(Color.WHITE)
       // canvas?.drawCircle(500f,500f,500f,paint)
       // canvas?.drawRect(RectF(0f,0f,500f,500f),paint)
        //paint.shader=bitmapShaderC
        //canvas?.drawCircle(500f,800f,300f,paint)
        val rectBitmap=Bitmap.createBitmap(400,500,Bitmap.Config.ARGB_8888)
        rectBitmap.eraseColor(Color.RED)
        val roundBitmap=Bitmap.createBitmap(300,300,Bitmap.Config.ARGB_8888)
        roundBitmap.eraseColor(Color.GRAY)
        val xfermode=PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)

        canvas?.drawBitmap(rectBitmap,0f,0f,paint)
        paint.xfermode = xfermode
        val bitmapS=BitmapShader(roundBitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        //paint.shader=bitmapS

        canvas?.drawBitmap(roundBitmap,300f,400f,paint)
      //  canvas?.drawCircle(400f,400f,200f,paint)
        paint.xfermode = null

    }
}