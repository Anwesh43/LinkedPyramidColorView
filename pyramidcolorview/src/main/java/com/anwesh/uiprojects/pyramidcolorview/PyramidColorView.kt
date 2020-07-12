package com.anwesh.uiprojects.pyramidcolorview

/**
 * Created by anweshmishra on 12/07/20.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Color
import android.content.Context
import android.app.Activity
import android.graphics.Path
import android.graphics.Canvas

val colors : Array<String> = arrayOf("#F44336", "#673AB7", "#8BC34A", "#03A9F4", "#009688")
val parts : Int = 2
val strokeFactor : Float = 90f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawPyramidLinePath(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, 2)
    val sf2 : Float = sf.divideScale(1, 2)
    val x1 : Float = w * sf1
    val x2 : Float = w * sf2
    val y1 : Float = (h / 2) * sf1
    val y2 : Float = (h / 2) * sf2
    paint.style = Paint.Style.FILL
    val path : Path = Path()
    path.moveTo(0f, 0f)
    path.lineTo(x2, -y2)
    path.lineTo(x2, y2)
    path.lineTo(0f, 0f)
    drawPath(path, paint)
    for (j in 0..1) {
        val si : Float = 1f - 2 * j
        drawLine(0f, 0f, x1, y1 * si, paint)
    }
}

fun Canvas.drawPLPNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(0f, h / 2)
    drawPyramidLinePath(scale, w, h, paint)
    restore()
}
