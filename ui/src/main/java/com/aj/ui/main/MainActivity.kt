package com.aj.ui.main

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.TextView
import com.aj.base_module.ui.activity.BaseActivity

import com.aj.ui.R
import com.aj.base_module.ui.activity.BaseDataBindVMActivity
import com.aj.base_module.ui.activity.BaseVMActivity
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.user_module.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main_ui.*

class MainActivity() : BaseActivity() {
    override fun initView() {
      tv_login.setOnClickListener { v ->
          var intent : Intent = Intent(this,LoginActivity::class.java)
          startActivity(intent)
      };

    }

    override fun getLayoutId(): Int  = R.layout.activity_main_ui;




}
