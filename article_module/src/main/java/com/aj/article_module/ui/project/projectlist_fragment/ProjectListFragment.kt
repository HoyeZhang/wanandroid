package com.aj.article_module.ui.project.projectlist_fragment


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import com.aj.article_module.adapter.ProjectListFMAdapter
import com.aj.article_module.bean.*
import com.aj.base_module.ui.fragment.BaseListPageFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.article_fragment_home.*


@Route(path = ArouterUrlManage.ARTICLE_PROJECTLIST_FRAGMENT)
class ProjectListFragment : BaseListPageFragment<ProjectDataItem>() {
    var projectId = 0
    private val projectListFMAdapter: ProjectListFMAdapter by lazy {
        ProjectListFMAdapter()
    }

    companion object {
        fun newInstance(cid: Int) =
            ProjectListFragment().apply {
                arguments = Bundle().apply {
                    putInt(PageDataInfo.projectId, cid)
                }
            }
    }

    override fun getLayoutRes(): Int = com.aj.base_module.R.layout.common_refresh_recyclerview

    private val mViewModel by lazy {
        initViewModel(
            this,
            ProjectListFmViewModel::class,
            ProjectListFmRepository::class
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle  = arguments
        projectId = bundle?.getInt(PageDataInfo.projectId)!!
    }
    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun initRecyclerView() {
        projectListFMAdapter.run {
            loadMoreModule.setOnLoadMoreListener {
                getListData()
            }

        }
        mRecyclerView.run {
            adapter = projectListFMAdapter
            layoutManager = linearLayoutManager
        }
        mViewModel.projectList.observe(this, mListObserver)
    }

    override fun getListData() {
        mViewModel.getProjectListByid(mPage,projectId)
    }

    override fun addData(it: List<ProjectDataItem>) {
        if (mPage == 1) {
            projectListFMAdapter.setList(it)
        } else {
            projectListFMAdapter.addData(it)
        }

        if (it.size < ItemDataType.pageOffset) {
            projectListFMAdapter.loadMoreModule.loadMoreEnd()
        } else {
            projectListFMAdapter.loadMoreModule.loadMoreComplete()
        }
    }

    override fun notifyDataSetChanged() {
    }

}