package com.aj.article_module.ui.official_account.official_account_article_list

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
 * @Description:    公众号文章列表页面
 * @Author:         zhy
 * @CreateDate:     2020/7/31 11:23
 */
@Route(path = ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_ARTICLE_LIST_ACTIVITY)
class OfficialAccountArticleListActivity : BaseFragmentActivity() {

    override fun setPageTitle(): String = "公众号文章"

    override fun setFragmentTag(): String = "OfficialAccountArticleListActivity"

    override fun setFragmentView(): Fragment {
        val bundle  = intent.extras
        return bundle?.let {
            ArouterPageManger.navigationForResultWithParams(ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_ARTICLE_LIST_FRAGMENT, it)
        } as Fragment
    }

}