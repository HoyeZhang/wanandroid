package com.aj.ui.main


import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.aj.base_module.ui.activity.BaseActivity
import com.aj.base_module.utils.imageLoader.ImageLoader
import com.aj.ui.R
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.LoginService
import com.aj.data_service.Service.SharedPreferencesService
import com.aj.data_service.Service.UserService
import com.aj.data_service.bean.DataUser

import com.aj.ui.adapter.AdapterFragmentPager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode

import kotlinx.android.synthetic.main.activity_main_ui.*


class MainActivity : BaseActivity() {

    @Autowired(name = ArouterUrlManage.USER_LOGIN_SERVICE)
    @JvmField
    var loginService: LoginService? = null

    @Autowired(name = ArouterUrlManage.DATAMODULEUSERSERVICE)
    @JvmField
    var userService: UserService? = null

    @Autowired(name = ArouterUrlManage.DATAMODULESHAREPREFERENCESSERVICE)
    @JvmField
    var sharedPreferencesService: SharedPreferencesService? = null


    private var dataUser: DataUser? = null

    /**
     * NavigationItemSelect监听
     */
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.action_home -> {
                    toolbar.title = getText(R.string.ui_home)
                    user_main_vp.setCurrentItem(0,false)
                    true
                }
                R.id.action_system -> {
                    toolbar.title = getText(R.string.ui_system)
                    user_main_vp.setCurrentItem(1,false)
                    true
                }
                R.id.action_project -> {
                    toolbar.title = getText(R.string.ui_project)
                    user_main_vp.setCurrentItem(2,false)
                    true
                }
                R.id.action_mine -> {
                    toolbar.title = getText(R.string.ui_mine)
                    user_main_vp.setCurrentItem(3,false)
                    true
                }
                else -> {
                    false
                }

            }
        }


    override fun initView() {


        toolbar.title = getText(R.string.ui_home)
        setSupportActionBar(toolbar);
//        ImageLoader.loadImage(this,iv_test,"https://oimagea1.ydstatic.com/image?id=1672530223168343552&product=adpublish&w=520&h=347")
        user_main_vp.adapter = AdapterFragmentPager(this)
        user_main_vp.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                user_main_bnv.menu.getItem(position).setChecked(true)
            }
        })
        //设置不滑动
        user_main_vp.isUserInputEnabled = false
        user_main_bnv.run {
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }


    }

    override fun initData() {
        super.initData()
        ARouter.getInstance().inject(this)

        if(sharedPreferencesService?.getIsLogin()!!){
            dataUser = userService?.queryLoginUser()!!
            dataUser?.let {
                loginService?.userLogin(it.username,it.password)
            }
        }

    }
    override fun getLayoutId(): Int  = R.layout.activity_main_ui;

}

