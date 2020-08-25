package com.aj.ui.main

import android.app.Application
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.AppContextService

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter

class App : Application() {

    @Autowired(name = ArouterUrlManage.DATAMODULEAPPCONTEXTSERVICE)
    @JvmField
    var appContextService: AppContextService? = null

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
        appContextService?.setAppContext(this)
    }
}