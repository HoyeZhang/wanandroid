package com.aj.user_module.ui.about

import androidx.fragment.app.Fragment
import com.aj.base_module.ui.activity.BaseFragmentActivity
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *
 * @Package:        com.aj.user_module.ui.about
 * @ClassName:      AboutActivity
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/9/10 16:51
 */
@Route(path = ArouterUrlManage.USER_ABOUTACTIVITY)
class AboutActivity : BaseFragmentActivity() {

    override fun setPageTitle(): String = "关于"

    override fun setFragmentTag(): String = "AboutFragment"


    override fun setFragmentView(): Fragment {
        val bundle  = intent.extras
        return bundle?.let {
            ArouterPageManger.navigationForResultWithParams(ArouterUrlManage.USER_ABOUTFRAGEMNT, it)
        } as Fragment
    }

}