package com.aj.base_module.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @Package:        com.aj.base_module.utils
 * @ClassName:      DateUtils
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/7/31 10:41
 */
object  DateUtils {
    /**
     *
     * @param time  1541569323155
     * @param pattern yyyy-MM-dd HH:mm:ss
     * @return 2018-11-07 13:42:03
     * 时间戳转换成字符串
     */
    fun getDate2String(time: Long, pattern: String?): String? {
        val date = Date(time)
        val format = SimpleDateFormat(pattern, Locale.getDefault())
        return format.format(date)
    }

    /**
     *
     * @param time  1541569323155
     * @return 2018-11-07
     * 时间戳转换成字符串
     */
    fun getDate2String(time: Long): String? {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }
}