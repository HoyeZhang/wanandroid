package com.aj.data_module.service

import android.content.Context
import android.util.Log
import com.aj.data_module.AppContext
import com.aj.data_module.dataprovide.UserDataProvide
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.AppContextService

import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = ArouterUrlManage.DATAMODULEAPPCONTEXTSERVICE, name = "APP上下文提供")
class AppContextServiceImpl : AppContextService {
    override fun setAppContext(context: Context) {
        AppContext.context = context
    }

    override fun init(context: Context?) {

    }

}