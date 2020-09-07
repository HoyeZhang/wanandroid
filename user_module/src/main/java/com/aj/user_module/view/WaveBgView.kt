package com.aj.user_module.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import kotlin.math.min


/**
 *
 * @Package:        com.aj.user_module.view
 * @ClassName:      WaveBgView
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/9/7 17:03
 */
class WaveBgView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    private var color: Int = Color.RED
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.color = color
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        var radius = min(width,height) /2f
//        canvas?.drawCircle(width/2f,height/2f,radius,paint)

    }

}


