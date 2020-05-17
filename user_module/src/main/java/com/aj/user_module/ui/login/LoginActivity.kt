package com.aj.user_module.ui.login

import com.aj.base_module.ui.activity.BaseDataBindActivity
import com.aj.base_module.ui.activity.BaseDataBindVMActivity
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.user_module.R
import com.aj.user_module.databinding.UserActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
/**
 * @author zhy
 * @time 2020/5/17.
 */
class LoginActivity : BaseDataBindActivity<UserActivityLoginBinding>() {



    override fun getLayoutId(): Int = R.layout.user_activity_login;
    private val mViewModel: LoginViewModel by viewModel()

    override fun initView() {

      mViewModel.login("ddd","ddd");
    }

    override fun initData() {
        super.initData()
    }



}