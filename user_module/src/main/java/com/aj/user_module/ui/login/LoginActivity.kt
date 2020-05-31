package com.aj.user_module.ui.login

import android.widget.Toast
import androidx.lifecycle.Observer
import com.aj.base_module.ui.activity.BaseDataBindActivity
import com.aj.base_module.ui.activity.BaseDataBindVMActivity
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.user_module.R
import com.aj.user_module.databinding.UserActivityLoginBinding
import kotlinx.android.synthetic.main.user_activity_login.*

/**
 * @author zhy
 * @time 2020/5/17.
 */
class LoginActivity : BaseDataBindVMActivity<UserActivityLoginBinding>() {
    override fun getViewModel(): BaseViewModel {
        return mViewModel;
    }

    override fun getLayoutId(): Int = R.layout.user_activity_login;
    private val mViewModel by lazy {
        initViewModel(
            this, LoginViewModel::class, LoginRepository::class
        )
    }

    override fun initView() {

        mViewModel.loginBean.observe(this, Observer { loginBean ->
            if (loginBean != null) {
                finish()
            }else{
                Toast.makeText(this,"ddd",Toast.LENGTH_LONG).show();
            }
        })


    }

    override fun initData() {
        bt_login.setOnClickListener {
            mViewModel.login(et_account.text.toString(),et_password.text.toString());
        }
    }



}