package com.aj.ui.main


import com.aj.base_module.ui.activity.BaseActivity
import com.aj.base_module.utlis.imageLoader.ImageLoader
import com.aj.ui.R
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.aj.ui.adapter.AdapterFragmentPager

import kotlinx.android.synthetic.main.activity_main_ui.*

class MainActivity : BaseActivity() {
    override fun initView() {
//      tv_login.setOnClickListener {
//          ArouterPageManger.navigation(this@MainActivity, ArouterUrlManage.USER_LOGINACTIVITY)
//      }
//        ImageLoader.loadImage(this,iv_test,"https://oimagea1.ydstatic.com/image?id=1672530223168343552&product=adpublish&w=520&h=347")

        user_main_vp.adapter = AdapterFragmentPager(this)

    }

    override fun getLayoutId(): Int  = R.layout.activity_main_ui;

}
