package com.aj.user_module.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.View


/**
 *
 * @Package:        com.aj.user_module.view
 * @ClassName:      WaveBgView
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/9/7 17:03
 */
class WaveBgView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private var color: Int = Color.RED
    private var paint: Paint = Paint()

    init {
        paint.color = color
        paint.style = (Paint.Style.FILL)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var radius = 3f
        var startValue: PointF = PointF(left.toFloat()- radius *3, bottom.toFloat()- radius *3)
        var endValue: PointF = PointF(right.toFloat()- radius *3, bottom.toFloat()- radius *3)
        Log.d("PointF1坐标", "yyy" + startValue.y + "xxxxx" + startValue.x)
        Log.d("PointF2坐标", "yyy" + endValue.y + "xxxxx" + endValue.x)
        var pointFs = getPointFs(startValue, endValue, 8)
        for (pointF in pointFs) {

            Log.d("圆坐标", "yyy" + pointF.y + "xxxxx" + pointF.x)
            canvas?.drawCircle(pointF.x, pointF.y - radius, radius, paint)
        }
    }


    private fun getPointFs(startValue: PointF, endValue: PointF, count: Int): MutableList<PointF> {
        val pointX = (startValue.x + endValue.x) / 2
        val pointY = (startValue.y - startValue.y / 2) / 2
        val controllPointF = PointF(pointX, pointY)
        var pointFs: MutableList<PointF> = ArrayList()
        for (index in 1..count) {
            var t: Float = index.toFloat() / count.toFloat()
            val x =
                ((1 - t) * (1 - t) * startValue.x + 2 * t * (1 - t) * controllPointF.x + t * t * endValue.x)
            val y =
                ((1 - t) * (1 - t) * startValue.y + 2 * t * (1 - t) * controllPointF.y + t * t * endValue.y)

            pointFs.add(PointF(x, y))
        }

        return pointFs

    }
}


