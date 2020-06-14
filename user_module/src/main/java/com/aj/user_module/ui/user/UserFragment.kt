package com.aj.user_module.ui.user

import android.os.Parcel
import android.os.Parcelable
import com.aj.base_module.ui.fragment.BaseDataBindVMFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.aj.user_module.R
import com.aj.user_module.databinding.UserFragmentUserBinding
import com.aj.user_module.ui.login.LoginRepository
import com.aj.user_module.ui.login.LoginViewModel

import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @author zhy
 * @time 2020/6/14.
 */
@Route(path = ArouterUrlManage.USER_FRAGEMNT)
class UserFragment : BaseDataBindVMFragment<UserFragmentUserBinding>() {
    private val mViewModel by lazy {
        initViewModel(
            this, UserFmViewModel::class, UserFmRepository::class
        )
    }
    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun getLayoutRes()= R.layout.user_fragment_user



    override fun initView() {

    }


}