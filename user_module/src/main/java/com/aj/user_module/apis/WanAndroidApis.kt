package com.aj.user_module.apis


import com.aj.base_module.net.BaseResponse
import com.aj.user_module.bean.LoginBean


import retrofit2.Call
import retrofit2.http.*

interface WanAndroidApis {
    /**
     * 登录
     */
    @POST("user/login")
    fun login(@QueryMap param: Map<String, String>): Call<BaseResponse<LoginBean>>


}