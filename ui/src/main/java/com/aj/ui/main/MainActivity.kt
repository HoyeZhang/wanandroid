package com.aj.ui.main


import com.aj.base_module.ui.activity.BaseActivity
import com.aj.base_module.utlis.imageLoader.ImageLoader
import com.aj.ui.R
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.aj.ui.adapter.AdapterFragmentPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode

import kotlinx.android.synthetic.main.activity_main_ui.*

class MainActivity : BaseActivity() {

    /**
     * NavigationItemSelect监听
     */
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.action_home -> {
                    user_main_vp.setCurrentItem(0,false)
                    true
                }
                R.id.action_system -> {
                    user_main_vp.setCurrentItem(1,false)
                    true
                }
                R.id.action_project -> {
                    user_main_vp.setCurrentItem(2,false)
                    true
                }
                R.id.action_mine -> {
                    user_main_vp.setCurrentItem(3,false)
                    true
                }
                else -> {
                    false
                }

            }
        }


    override fun initView() {

//        ImageLoader.loadImage(this,iv_test,"https://oimagea1.ydstatic.com/image?id=1672530223168343552&product=adpublish&w=520&h=347")

        user_main_vp.adapter = AdapterFragmentPager(this)

        user_main_bnv.run {
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }


    }

    override fun getLayoutId(): Int  = R.layout.activity_main_ui;

}
