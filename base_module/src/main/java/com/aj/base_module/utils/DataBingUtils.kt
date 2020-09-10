package com.aj.base_module.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.aj.base_module.utils.imageLoader.ImageLoader
import com.bumptech.glide.Glide


/**
 *
 * @Package:        com.aj.base_module.utils
 * @ClassName:      DatabingUtils
 * @Description:    databing 自定义属性
 * @Author:         zhy
 * @CreateDate:     2020/9/10 15:45
 */

 object DataBingUtils{
    @BindingAdapter("app:image_url")
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        ImageLoader.loadImage(view.context,view,url)
    }

    @BindingAdapter("app:image_url")
    @JvmStatic
    fun loadImage(view: ImageView, url: Int) {
        ImageLoader.loadImage(view.context,view,url)
    }
}