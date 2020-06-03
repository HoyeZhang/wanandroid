package com.aj.ui.main

import android.app.Application
import com.aj.data_module.AppContext
import com.alibaba.android.arouter.launcher.ARouter

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContext.context = this;

        ARouter.init(this)
    }
}