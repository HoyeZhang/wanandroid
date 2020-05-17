package com.aj.base_module.ui.net

data class  BaseResponse<T>(val errorMsg: String, val errorCode: Int, var data: T)