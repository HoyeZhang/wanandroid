package com.aj.article_module.ui.search

import com.aj.article_module.R
import com.aj.base_module.ui.fragment.BaseVMFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *
 * @Package:        com.aj.article_module.ui.search
 * @ClassName:      SearchFragment
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/9/25 10:17
 */
@Route(path = ArouterUrlManage.ARTICLE_SEARCH_FRAGMENT)
class SearchFragment : BaseVMFragment()  {
    override fun getLayoutRes(): Int = R.layout.article_layout_fm_search

    private val mViewModel by lazy {
        initViewModel(
            this, SearchFmViewModel::class, SearchFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }


    override fun initView() {

    }
}