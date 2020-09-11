package com.aj.data_service.Service

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 *
 * @Package:        com.aj.data_service.Service
 * @ClassName:      SharedPreferencesService
 * @Description:    SharedPreferences 相关操作服务提供
 * @Author:         zhy
 * @CreateDate:     2020/9/11 11:50
 */
interface SharedPreferencesService : IProvider {

    fun setIsLogin(isLogin : Boolean)

    fun getIsLogin() : Boolean
}