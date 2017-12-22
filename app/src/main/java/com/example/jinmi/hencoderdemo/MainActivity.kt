package com.example.jinmi.hencoderdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

fun dp2px(context:Context,dpValue:Float):Int{
    val scale=context.resources.displayMetrics.density
    return (dpValue*scale+0.5f).toInt()
}
fun px2dp(context: Context,pxValue:Float):Int{
    val scale=context.resources.displayMetrics.density
    return (pxValue/scale+0.5f).toInt()
}
fun sp2px(context: Context,spValue:Float):Int{
    val  scale=context.resources.displayMetrics.scaledDensity
    return (scale*spValue+0.5f).toInt()
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        setContentView(PaintBasicView4(this))
    }
}
