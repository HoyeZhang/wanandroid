package com.aj.data_module.dataprovide


import com.aj.data_module.utils.PreferencesUtil

/**
 *
 * @Package:        com.aj.data_module.dataprovide
 * @ClassName:      PreferencesProvide
 * @Description:    统一SharedPreferences 字段提供保存
 * @Author:         zhy
 * @CreateDate:     2020/9/11 11:43
 */
object PreferencesProvide {
    private const val IS_LOGIN = "IS_LOGIN"

    fun setIsLogin(isLogin : Boolean){
        PreferencesUtil.saveValue(IS_LOGIN,isLogin)
    }

    fun getIsLogin() : Boolean{
        return PreferencesUtil.getBoolean(IS_LOGIN,default = false)
    }
}