package com.aj.base_module.utlis.imageLoader

import android.content.Context

interface BaseImageLoaderStrategy<T : ImageConfig?> {
    /**
     * 加载图片
     *
     * @param ctx [Context]
     * @param config 图片加载配置信息
     */
     fun loadImage( ctx: Context?,  config: T)

    /**
     * 停止加载
     *
     * @param ctx [Context]
     * @param config 图片加载配置信息
     */
    fun clear( ctx: Context?, config: T)
}
