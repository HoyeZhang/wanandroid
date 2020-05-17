package com.aj.base_module.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.ErrorState
import com.aj.base_module.ui.viewmodel.LoadState
import com.aj.base_module.ui.viewmodel.SuccessState

abstract class BaseVMActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout()
    }

    protected fun initViewModelAction() {
        getViewModel().let { baseViewModel ->
            baseViewModel.mStateLiveData.observe(this, Observer { stateActionState ->
                when (stateActionState) {
                    LoadState -> showLoading()
                    SuccessState -> dismissLoading()
                    is ErrorState -> {
                        dismissLoading()
                        stateActionState.message?.apply {

                            handleError()
                        }
                    }
                }
            })
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun getViewModel(): BaseViewModel

    open fun setContentLayout() {
        setContentView(getLayoutId())
        initViewModelAction()
        initView()
        initData()
    }

    open fun initData() {

    }

    open fun showLoading() {

    }

    open fun dismissLoading() {

    }

    open fun handleError() {

    }
}