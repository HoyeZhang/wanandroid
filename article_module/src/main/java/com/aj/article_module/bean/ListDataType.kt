package com.aj.article_module.bean

/**
 *
 * @Package:        com.aj.article_module.bean
 * @ClassName:      ListDataType
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/6/16 14:27
 */

interface HomeListDataType {
    val dataType: Int
}


object ItemDataType {
    //从玩android 文档上看每次20个数据，但是返回数据会有偏差
    const val pageOffset: Int = 15


    const val Articles = 1//文章

    const val OfficialAccount = 2//公众号
}