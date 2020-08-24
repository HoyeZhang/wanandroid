package com.aj.base_module.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 *
 * @Package:        com.aj.base_module.utils
 * @ClassName:      ContextCompatUtils
 * @Description:    获取系统资源过时方法 代替
 * @Author:         zhy
 * @CreateDate:     2020/8/24 16:41
 */
object ContextCompatUtils {

    /**
     * 获取资源颜色
     */
    fun getColor(context : Context, @ColorRes id : Int): Int{

        return ContextCompat.getColor(context,id)
    }


    /**
     * 获取资源颜色
     */
    fun getDrawable(context : Context, @DrawableRes id : Int): Drawable? {
        return ContextCompat.getDrawable(context,id)
    }

}