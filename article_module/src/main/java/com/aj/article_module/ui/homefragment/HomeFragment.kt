package com.aj.article_module.ui.homefragment

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aj.article_module.R
import com.aj.article_module.adapter.HomeListAdapter
import com.aj.article_module.bean.ListDataType
import com.aj.base_module.ui.fragment.BaseDataBindVMFragment
import com.aj.base_module.ui.fragment.BaseListPageFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage


import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.article_fragment_home.*


/**
 * @author zhy
 * @time 2020/6/14.
 */
@Route(path = ArouterUrlManage.ARYTICLE_HOME_FRAGEMNT)
class HomeFragment : BaseListPageFragment<ListDataType>() {

    override fun getLayoutRes(): Int = com.aj.base_module.R.layout.common_refresh_recyclerview

    private val mViewModel by lazy {
        initViewModel(
            this, HomeFmViewModel::class, HomeFmRepository::class
        )
    }

    /**
     * Home Adapter
     */
    private val homeAdapter: HomeListAdapter by lazy {
        HomeListAdapter()
    }


    /**
     * LinearLayoutManager
     */
    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }


    override fun initRecyclerView() {
        homeAdapter.run {
            loadMoreModule.setOnLoadMoreListener {
                getListData()
            }
        }
        mRecyclerView.run {
            adapter = homeAdapter
            layoutManager = linearLayoutManager
        }

        mViewModel.articleList.observe(this,mListObserver)

        mViewModel.officialAccount.observe(this, Observer {

        })
    }

    override fun getListData() {
        if (mPage == 1){
            mViewModel.getWxArticle()
        }
        mViewModel.getArticles(mPage ++)
    }

    override fun notifyDataSetChanged() {
        homeAdapter.setList(mListData)
    }
}