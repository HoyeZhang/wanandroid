package com.aj.user_module.ui.login


import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.aj.base_module.ui.activity.BaseDataBindVMActivity
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.UserService
import com.aj.data_service.bean.DataUser
import com.aj.user_module.R
import com.aj.user_module.databinding.UserActivityLoginBinding
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.user_activity_login.*

/**
 * @author zhy
 * @time 2020/5/17.
 */
@Route(path = ArouterUrlManage.USER_LOGINACTIVITY)
class LoginActivity : BaseDataBindVMActivity<UserActivityLoginBinding>(), View.OnClickListener {
    @Autowired(name = ArouterUrlManage.DATAMODULEUSERSERVICE)
    @JvmField
    var userService: UserService? = null
    private var dataUsers: ArrayList<DataUser>? = null

    override fun getLayoutId(): Int = R.layout.user_activity_login
    private val mViewModel by lazy {
        initViewModel(
            this, LoginViewModel::class, LoginRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel;
    }

    override fun initView() {
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener {
            this.finish()
        }

        mViewModel.loginBean.observe(this, Observer { loginBean ->
            if (loginBean != null) {
                finish()
            }
        })
        bt_login.setOnClickListener(this)
        tv_goto_registered.setOnClickListener(this)
    }

    override fun initData() {
        ARouter.getInstance().inject(this)
        dataUsers = userService?.queryAll()!!
        if(dataUsers!!.size > 0){
            et_account.setText(dataUsers!![0].username)
            et_password.setText(dataUsers!![0].password)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_login -> {
                mViewModel.login(et_account.text.toString(), et_password.text.toString())
            }

            R.id.tv_goto_registered -> {
                ArouterPageManger.navigation(this, ArouterUrlManage.USER_REGISTERED_ACTIVITY)
                finish()
            }

            else -> {}
        }
    }


}