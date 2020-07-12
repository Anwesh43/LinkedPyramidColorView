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
