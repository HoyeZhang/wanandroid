package com.aj.article_module.ui.search

import androidx.fragment.app.Fragment
import com.aj.article_module.bean.PageDataInfo
import com.aj.base_module.ui.activity.BaseFragmentActivity
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *
 * @Package:        com.aj.article_module.ui.search
 * @ClassName:      SearchActivity
 * @Description:    搜索
 * @Author:         zhy
 * @CreateDate:     2020/9/25 10:14
 */
@Route(path = ArouterUrlManage.ARTICLE_SEARCH_ACTIVITY)
class SearchActivity : BaseFragmentActivity() {

    override fun setPageTitle(): String = "搜索页面"

    override fun setFragmentTag(): String = "SearchFragment"

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
            ArouterPageManger.navigationForResultWithParams(ArouterUrlManage.ARTICLE_SEARCH_FRAGMENT, it)
        } as Fragment
    }

}