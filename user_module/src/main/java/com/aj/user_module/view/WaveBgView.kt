package com.aj.user_module.view

import android.R.attr.end
import android.R.attr.start
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.aj.base_module.utils.ContextCompatUtils
import com.aj.user_module.R
import kotlin.random.Random


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
    private var paint: Paint = Paint().apply {
        isAntiAlias = true
        isDither = true
        isFilterBitmap = true
    }

    private val colors = intArrayOf(
        R.color.base_colorAccent,
        R.color.base_colorPrimary,
        R.color.base_colorPrimaryDark,
        R.color.base_color_BDBDBD,
        R.color.base_color_cyan,
        R.color.base_color_blue
    )


    init {
        paint.color = color
        paint.style = (Paint.Style.FILL)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var radius = 3f
        var startValue: PointF = PointF(radius *3, height - radius *3)
        var endValue: PointF = PointF(width- radius *3, height - radius *3)
        var controlPointF = PointF(width.toFloat()/4,0f)
        var pointFs = getPointFs(startValue, endValue,controlPointF, 15)
        var  radiusRandom = radius
            for (pointF in pointFs) {
            paint.color = ContextCompatUtils.getColor(context,colors[Random.nextInt(colors.size)])
                radiusRandom = radius + Random.nextInt(15)
            canvas?.drawCircle(pointF.x, pointF.y - radiusRandom, radiusRandom, paint)
        }


    }

    /**
     * 获取贝塞尔点的位置
     */
    private fun getPointFs(startValue: PointF, endValue: PointF,controlPointF: PointF,  count: Int): MutableList<PointF> {

        var pointFs: MutableList<PointF> = ArrayList()
        for (index in 1..count) {
            var t: Float = index.toFloat() / count.toFloat()
            val x =
                ((1 - t) * (1 - t) * startValue.x + 2 * t * (1 - t) * controlPointF.x + t * t * endValue.x)
            val y =
                ((1 - t) * (1 - t) * startValue.y + 2 * t * (1 - t) * controlPointF.y + t * t * endValue.y)

            pointFs.add(PointF(x, y))
        }

        return pointFs

    }
}


