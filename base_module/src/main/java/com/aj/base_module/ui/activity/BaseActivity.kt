package com.aj.base_module.ui.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author zhy
 * @time 2020/5/16.
 */
abstract  class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout()
    }

    open fun setContentLayout() {
        setContentView(getLayoutId())
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    open fun initData() {
    }

}