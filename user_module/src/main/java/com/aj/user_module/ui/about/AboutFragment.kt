package com.aj.user_module.ui.about

import com.aj.base_module.ui.fragment.BaseDataBindVMFragment
import com.aj.base_module.ui.fragment.BaseVMFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.base_module.utils.PackageUtils
import com.aj.data_service.ArouterUrlManage
import com.aj.user_module.R
import com.aj.user_module.databinding.UserFragmentAboutBinding
import com.alibaba.android.arouter.facade.annotation.Route

import kotlinx.android.synthetic.main.user_fragment_about.*


@Route(path = ArouterUrlManage.USER_ABOUTFRAGEMNT)
class AboutFragment : BaseDataBindVMFragment<UserFragmentAboutBinding>() {

    override fun getLayoutRes(): Int = R.layout.user_fragment_about


    private val mViewModel by lazy {
        initViewModel(
            this, AboutFmViewModel::class, AboutFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun initView() {
        tv_version.text= "版本 "+PackageUtils.getVersionName(mActivity)
        tv_app_name.text= PackageUtils.getAppName(mActivity)
        tv_mail.text = "联系我 " + R.string.user_mail
        tv_code.text = "仓库地址 " + R.string.user_code_url
    }

}