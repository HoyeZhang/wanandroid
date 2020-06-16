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

    protected val mListData = ObservableArrayList<M>()

    protected var mPage = 1

    override fun getLayoutRes(): Int = R.layout.common_refresh_recyclerview

    override fun initView() {
        initRefreshLayout()
        initRecyclerView()
        initViewModelAction()
    }

    private fun initRefreshLayout() {
        mRefreshLayout.run {
            setOnRefreshListener(this@BaseListPageFragment)
        }
    }


    override fun onRefresh() {
        mPage = 1
        initViewModelAction()
    }



    protected fun initViewModelAction() {
        if (mPage == 1) {
            mRefreshLayout.isRefreshing = true
        }
        getListData()
    }

    protected val mListObserver = Observer<List<M>> {

        if (it != null && it.isNotEmpty()) {
            if (mPage == 1) {
                mListData.clear()
                mListData.addAll(it)
                mRefreshLayout.isRefreshing = false
            } else {
                mListData.addAll(it)
            }
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
     * 回调数据改变
     */
    abstract fun notifyDataSetChanged()

}