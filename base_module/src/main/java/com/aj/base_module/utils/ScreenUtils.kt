package com.aj.base_module.utils

import android.content.Context
import android.util.TypedValue




/**
 *
 * @Package:        com.aj.base_module.utils
 * @ClassName:      ScreenUtils
 * @Description:    尺寸相关utils
 * @Author:         zhy
 * @CreateDate:     2020/8/24 15:22
 */
object ScreenUtils {

    /**
    * dp转px
    *
    * @param context
    * @param dpVal
    * @return
    */
    open fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal, context.getResources().getDisplayMetrics()
        ).toInt()
    }
}