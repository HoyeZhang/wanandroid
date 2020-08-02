package com.aj.article_module.ui.official_account.official_account_list

import com.aj.article_module.bean.OfficialAccountItem
import com.aj.article_module.ui.homefragment.HomeFmRepository
import com.aj.article_module.ui.homefragment.HomeFmViewModel
import com.aj.base_module.ui.fragment.BaseListPageFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *
 * @Package:        com.aj.article_module.ui.official_account.official_account_list
 * @ClassName:      OfficialAccountListFragment
 * @Description:    公众号列表页面
 * @Author:         zhy
 * @CreateDate:     2020/7/31 14:35
 */
@Route(path = ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_LIST_FRAGMENT)
class OfficialAccountListFragment : BaseListPageFragment<OfficialAccountItem>() {

    override fun getLayoutRes(): Int = com.aj.base_module.R.layout.common_refresh_recyclerview

    private val mViewModel by lazy {
        initViewModel(
            this, OfficialAccountListFmViewModel::class, OfficialAccountListFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }
    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }

    override fun getListData() {
        mViewModel.getWxArticle()
    }

    override fun addData(it: List<OfficialAccountItem>) {
        TODO("Not yet implemented")
    }

    override fun notifyDataSetChanged() {
        TODO("Not yet implemented")
    }


}