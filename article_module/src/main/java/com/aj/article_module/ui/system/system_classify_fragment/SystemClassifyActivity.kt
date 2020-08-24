package com.aj.article_module.ui.system.system_classify_fragment

import androidx.fragment.app.Fragment
import com.aj.article_module.bean.PageDataInfo
import com.aj.base_module.ui.activity.BaseFragmentActivity
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *
 * @Package:        com.aj.article_module.ui.official_account.official_account_article_list
 * @ClassName:      OfficialAccountArticleListActivity
 * @Description:    体系类别页面
 * @Author:         zhy
 * @CreateDate:     2020/7/31 11:23
 */
@Route(path = ArouterUrlManage.ARTICLE_SYSTEM_CLASSIFY_ACTIVITY)
class SystemClassifyActivity : BaseFragmentActivity() {

    override fun setPageTitle(): String = "体系类别页面"

    override fun setFragmentTag(): String = "SystemClassifyFragment"

    override fun initView() {
        super.initView()
        val bundle  = intent.extras
        if (bundle != null) {
            changePageTitle( bundle.getString(PageDataInfo.systemTreeName,"体系类别页面"))
        }
    }
    override fun setFragmentView(): Fragment {
        val bundle  = intent.extras
        return bundle?.let {
            ArouterPageManger.navigationForResultWithParams(ArouterUrlManage.ARTICLE_SYSTEM_CLASSIFY_FRAGMENT, it)
        } as Fragment
    }

}