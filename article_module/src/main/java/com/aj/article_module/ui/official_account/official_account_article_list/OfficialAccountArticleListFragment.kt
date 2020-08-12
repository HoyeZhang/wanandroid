package com.aj.article_module.ui.official_account.official_account_article_list


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.aj.article_module.adapter.OfficialAccountArticleListFMAdapter
import com.aj.article_module.adapter.OfficialAccountListFMAdapter
import com.aj.article_module.bean.Article
import com.aj.article_module.bean.ItemDataType

import com.aj.article_module.bean.PageDataInfo
import com.aj.base_module.ui.fragment.BaseListPageFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.article_fragment_home.*

/**
 *
 * @Package:        com.aj.article_module.ui.official_account.official_account_article_list
 * @ClassName:      OfficialAccountListFragment
 * @Description:    公众号文章列表页面
 * @Author:         zhy
 * @CreateDate:     2020/7/31 14:35
 */
@Route(path = ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_ARTICLE_LIST_FRAGMENT)
class OfficialAccountArticleListFragment : BaseListPageFragment<Article>() {
    var officialAccountId = 0
    private val accountListFMAdapter: OfficialAccountArticleListFMAdapter by lazy {
        OfficialAccountArticleListFMAdapter()
    }

    override fun getLayoutRes(): Int = com.aj.base_module.R.layout.common_refresh_recyclerview

    private val mViewModel by lazy {
        initViewModel(
            this,
            OfficialAccountArticleListFmViewModel::class,
            OfficialAccountArticleListFmRepository::class
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle  = arguments
        officialAccountId = bundle?.getInt(PageDataInfo.officialAccountId)!!
    }
    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun initRecyclerView() {
        accountListFMAdapter.run {
            loadMoreModule.setOnLoadMoreListener {
                getListData()
            }

        }
        mRecyclerView.run {
            adapter = accountListFMAdapter
            layoutManager = linearLayoutManager
        }
        mViewModel.articleList.observe(this, mListObserver)
    }

    override fun getListData() {
        mViewModel.getOfficialAccountArticleList(officialAccountId, mPage)
    }

    override fun addData(it: List<Article>) {
        if (mPage == 1) {
            accountListFMAdapter.setList(it)
        } else {
            accountListFMAdapter.addData(it)
        }

        if (it.size < ItemDataType.pageOffset) {
            accountListFMAdapter.loadMoreModule.loadMoreEnd()
        } else {
            accountListFMAdapter.loadMoreModule.loadMoreComplete()
        }
    }

    override fun notifyDataSetChanged() {
    }

}