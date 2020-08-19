package com.aj.article_module.ui.project.projectlist_fragment


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.aj.article_module.adapter.OfficialAccountArticleListFMAdapter

import com.aj.article_module.bean.*
import com.aj.base_module.ui.fragment.BaseListPageFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.article_fragment_home.*


@Route(path = ArouterUrlManage.ARTICLE_SYSTEM_LIST_FRAGMENT)
class SystemListFragment : BaseListPageFragment<Article>() {
    private var projectId = 0
    private val systemListFMAdapter: OfficialAccountArticleListFMAdapter by lazy {
        OfficialAccountArticleListFMAdapter()
    }

    companion object {
        fun newInstance(cid: Int) =
            SystemListFragment().apply {
                arguments = Bundle().apply {
                    putInt(PageDataInfo.projectId, cid)
                }
            }
    }

    override fun getLayoutRes(): Int = com.aj.base_module.R.layout.common_refresh_recyclerview

    private val mViewModel by lazy {
        initViewModel(
            this,
            SystemListFmViewModel::class,
            SystemListFmRepository::class
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle  = arguments
        projectId = bundle?.getInt(PageDataInfo.projectId)!!
        super.onViewCreated(view, savedInstanceState)
    }
    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun initRecyclerView() {
        systemListFMAdapter.run {
            loadMoreModule.setOnLoadMoreListener {
                getListData()
            }

        }
        mRecyclerView.run {
            adapter = systemListFMAdapter
            layoutManager = linearLayoutManager
        }
        mViewModel.articleList.observe(this, mListObserver)
    }

    override fun getListData() {
        mViewModel.getSystemTreeArticle(mPage,projectId)
    }

    override fun addData(it: List<Article>) {
        if (mPage == 0) {
            systemListFMAdapter.setList(it)
        } else {
            systemListFMAdapter.addData(it)
        }

        if (it.size < ItemDataType.pageOffset) {
            systemListFMAdapter.loadMoreModule.loadMoreEnd()
        } else {
            systemListFMAdapter.loadMoreModule.loadMoreComplete()
        }
    }

    override fun notifyDataSetChanged() {
    }

}