package com.aj.base_module.utils.imageLoader

import android.widget.ImageView

class ImageConfig (
    var url: String? = null,
    var resourcesId : Int? = null,
    var imageView: ImageView? = null,
    var placeholder : Int ? =null,
    var errorPic : Int ? = null //错误占位符

)
