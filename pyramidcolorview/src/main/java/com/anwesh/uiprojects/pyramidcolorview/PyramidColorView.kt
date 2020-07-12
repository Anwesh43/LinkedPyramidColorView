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

val colors : Array<String> = arrayOf("#F44336", "#673AB7", "#8BC34A", "#03A9F4", "#009688")
val parts : Int = 2
val strokeFactor : Float = 90f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()
