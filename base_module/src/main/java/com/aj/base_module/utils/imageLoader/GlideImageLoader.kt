package com.aj.base_module.utils.imageLoader

import android.content.Context
import com.bumptech.glide.Glide

class GlideImageLoader : BaseImageLoaderStrategy<ImageConfig> {


    override fun loadImage(ctx: Context?, config: ImageConfig) {
        ctx?.let { config.imageView?.let { it1 -> Glide.with(it).load(config.url).into(it1) } }
    }

    override fun clear(ctx: Context?, config: ImageConfig) {

    }

}