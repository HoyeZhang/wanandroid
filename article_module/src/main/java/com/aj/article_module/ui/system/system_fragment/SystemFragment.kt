package com.aj.article_module.ui.system.system_fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.aj.article_module.R

import com.aj.article_module.adapter.SystemTreeFMAdapter
import com.aj.article_module.bean.SystemTreeBean
import com.aj.base_module.ui.fragment.BaseListPageFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.article_fragment_home.*

/**
 * @author zhy
 * @time 2020/8/16.
 */
@Route(path = ArouterUrlManage.ARTICLE_SYSTEM_FRAGMENT)
class SystemFragment : BaseListPageFragment<SystemTreeBean>() {

    override fun getLayoutRes(): Int = R.layout.common_refresh_recyclerview

    private val mViewModel by lazy {
        initViewModel(
            this, SystemFmViewModel::class, SystemFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }


    override fun initData() {
        super.initData()
        mViewModel.getProjectTree()
    }

    private val systemTreeFMAdapter: SystemTreeFMAdapter by lazy {
        SystemTreeFMAdapter()
    }


    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }


    override fun initRecyclerView() {

        mRecyclerView.run {
            adapter = systemTreeFMAdapter
            layoutManager = linearLayoutManager
        }
        mViewModel.systemTreeBean.observe(this, mListObserver)
    }

    override fun getListData() {
        mViewModel.getProjectTree()
    }

    override fun addData(it: List<SystemTreeBean>) {
        if (mPage == 0) {
            systemTreeFMAdapter.setList(it)
        } else {
            systemTreeFMAdapter.addData(it)
        }

    }

}