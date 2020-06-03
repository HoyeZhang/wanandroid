package com.aj.ui.main

import android.app.Application
import com.aj.data_module.AppContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContext.context = this;
    }
}