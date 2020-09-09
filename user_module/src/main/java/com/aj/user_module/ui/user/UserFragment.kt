package com.aj.user_module.ui.user

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.aj.base_module.ui.fragment.BaseDataBindVMFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.UserService
import com.aj.data_service.bean.DataUser
import com.aj.user_module.R
import com.aj.user_module.databinding.UserFragmentUserBinding
import com.aj.user_module.ui.login.LoginRepository
import com.aj.user_module.ui.login.LoginViewModel
import com.alibaba.android.arouter.facade.annotation.Autowired

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.user_fragment_user.*

/**
 * @author zhy
 * @time 2020/6/14.
 */
@Route(path = ArouterUrlManage.USER_FRAGEMNT)
class UserFragment : BaseDataBindVMFragment<UserFragmentUserBinding>() {

    @Autowired(name = ArouterUrlManage.DATAMODULEUSERSERVICE)
    @JvmField
    var userService: UserService? = null

    private var dataUser: DataUser? = null

    private val mViewModel by lazy {
        initViewModel(
            this, UserFmViewModel::class, UserFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun getLayoutRes() = R.layout.user_fragment_user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun initView() {

        tv_goto_login.setOnClickListener {
            ArouterPageManger.navigation(mActivity, ArouterUrlManage.USER_LOGINACTIVITY)
        }

        dataUser = userService?.queryLoginUser()!!
        tv_username.text = dataUser!!.username

        tv_logout.setOnClickListener {
            userService!!.clearLoginUser()
        }
    }

}