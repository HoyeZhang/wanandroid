package com.aj.ui.main

import android.app.Application
import com.aj.data_module.AppContext
import com.alibaba.android.arouter.launcher.ARouter
import me.jessyan.autosize.AutoSize
import android.app.Activity
import me.jessyan.autosize.utils.ScreenUtils
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.onAdaptListener
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContext.context = this;

        ARouter.init(this)

        AutoSize.initCompatMultiProcess(this);
        AutoSizeConfig.getInstance().onAdaptListener = object : onAdaptListener {
            override fun onAdaptBefore(target: Any, activity: Activity) {
                //使用以下代码, 可支持 Android 的分屏或缩放模式, 但前提是在分屏或缩放模式下当用户改变您 App 的窗口大小时
                //系统会重绘当前的页面, 经测试在某些机型, 某些情况下系统不会重绘当前页面, ScreenUtils.getScreenSize(activity) 的参数一定要不要传 Application!!!
                AutoSizeConfig.getInstance().screenWidth = ScreenUtils.getScreenSize(activity)[0]
                AutoSizeConfig.getInstance().screenHeight = ScreenUtils.getScreenSize(activity)[1]
            }

            override fun onAdaptAfter(target: Any, activity: Activity) {

            }
        }
    }
}