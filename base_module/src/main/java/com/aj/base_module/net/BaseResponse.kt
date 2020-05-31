package com.aj.base_module.net

data class  BaseResponse<T>(val errorMsg: String, val errorCode: Int, var data: T)