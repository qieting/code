package com.example.demo.listview_topuch

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ListView
import kotlin.math.abs

class ListTouchView(context: Context?, attrs: AttributeSet? = null) :
    ListView(context, attrs) {


    private var oldX = 0f;
    private var oldY = 0f;
    private var stats = STATS.NULL


    override fun onTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                oldX = ev.x
                oldY = ev.y
                stats = STATS.NULL
                return super.onTouchEvent(ev)
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e("hsy","1")
                if (stats == STATS.NULL) {
                    if (abs(ev.x - oldX) > abs(ev.y - oldY)) {
                        stats = STATS.H
                    } else {
                        stats = STATS.V
                    }
                }
                if (stats == STATS.H) {

                    if (ev.getY() >= this.height - 100) {
                        scrollBy(0, (ev.y - oldY).toInt())
                    }
                    oldX = ev.x
                    oldY = ev.y
                    return false
                }

            }
            else -> {
                Log.e("hsy","2")
                stats = STATS.NULL
            }
        }
        return super.onTouchEvent(ev)
    }


}

enum class STATS {
    NULL, V, H
}