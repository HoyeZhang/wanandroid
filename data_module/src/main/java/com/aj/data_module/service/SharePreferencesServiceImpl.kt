package com.aj.data_module.service

import android.content.Context
import com.aj.data_module.dataprovide.PreferencesProvide
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.SharedPreferencesService

import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = ArouterUrlManage.DATAMODULESHAREPREFERENCESSERVICE, name = "SharePreferences")
class SharePreferencesServiceImpl : SharedPreferencesService {
    override fun setIsLogin(isLogin: Boolean) {
        PreferencesProvide.setIsLogin(isLogin)
    }

    override fun getIsLogin(): Boolean {
      return  PreferencesProvide.getIsLogin()
    }


    override fun init(context: Context?) {

    }

}