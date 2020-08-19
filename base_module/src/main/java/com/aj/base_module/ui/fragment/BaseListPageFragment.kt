package com.aj.base_module.ui.fragment

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.aj.base_module.R
import kotlinx.android.synthetic.main.common_refresh_recyclerview.*


/**
 * 列表页面封装
 */
abstract class BaseListPageFragment<M> : BaseVMFragment(), SwipeRefreshLayout.OnRefreshListener {

    protected var mPage = 0

    override fun getLayoutRes(): Int = R.layout.common_refresh_recyclerview

    override fun initView() {
        initRefreshLayout()
        initRecyclerView()
    }

    private fun initRefreshLayout() {
        mRefreshLayout.run {
            setOnRefreshListener(this@BaseListPageFragment)
        }
        mRefreshLayout.setColorSchemeResources(R.color.base_colorAccent,R.color.base_colorPrimary)
    }

    override fun onRefresh() {
        mPage = 0
        initData()
    }

    override fun initData() {
        if (mPage == 0) {
            mRefreshLayout.isRefreshing = true
        }

        getListData()
    }

    protected val mListObserver = Observer<List<M>> {
        mRefreshLayout.isRefreshing = false
        if (it != null && it.isNotEmpty()) {
//            if (mPage == 1) {
//                addData(it)
//            } else {
                addData(it)
                mPage ++
 //           }
            notifyDataSetChanged()
        }
    }

    override fun dismissLoading() {
        mRefreshLayout.run {
            mRefreshLayout.isRefreshing = false
        }
    }

    abstract fun initRecyclerView()

    abstract fun getListData()

    /**
     * 设置数据
     */
    abstract fun addData(it: List<M>)


    /**
     * 回调数据改变
     */
    open fun notifyDataSetChanged(){

    }

}