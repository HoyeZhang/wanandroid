package com.aj.ui.main

import android.app.Application
import com.aj.base_module.BuildConfig
import com.aj.base_module.net.Const

import com.aj.ui.init.InitDataModuleContext

import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.bugly.crashreport.CrashReport

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        //初始化 arouter
        if (BuildConfig.LOG_DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        InitDataModuleContext(this)

        //bugly初始化
        CrashReport.initCrashReport(applicationContext, Const.BUGLY_APP_ID, true);
    }
}