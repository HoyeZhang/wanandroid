package com.aj.article_module.ui.official_account.official_account_list

import androidx.fragment.app.Fragment
import com.aj.base_module.ui.activity.BaseFragmentActivity
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *
 * @Package:        com.aj.article_module.ui.official_account.official_account_list
 * @ClassName:      OfficialAccountListActivity
 * @Description:    公众号列表页面
 * @Author:         zhy
 * @CreateDate:     2020/7/31 11:23
 */
@Route(path = ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_LIST_ACTIVITY)
class OfficialAccountListActivity : BaseFragmentActivity() {
    override fun setPageTitle(): String = "公众号列表"

    override fun setFragmentTag(): String = "OfficialAccountListActivity"

    override fun setFragmentView(): Fragment {
        return ArouterPageManger.navigationForResult(ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_LIST_FRAGMENT) as Fragment
    }

}