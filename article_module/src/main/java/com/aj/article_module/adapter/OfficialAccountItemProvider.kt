package com.aj.article_module.adapter


import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aj.article_module.R
import com.aj.article_module.bean.HomeListDataType

import com.aj.article_module.bean.ItemDataType

import com.aj.article_module.bean.OfficialAccount
import com.aj.article_module.databinding.ArticleItemOfficialaccountBinding
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      ArticlesItemProvider
 * @Description:    公众号列表
 * @Author:         zhy
 * @CreateDate:     2020/6/16 14:32
 */

class OfficialAccountItemProvider : BaseItemProvider<HomeListDataType>() {

    override val itemViewType: Int
        get() = ItemDataType.OfficialAccount
    override val layoutId: Int
        get() = R.layout.article_item_officialaccount

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
        var rvOfficialAccount = viewHolder.itemView.findViewById<View>(R.id.rv_official_account) as RecyclerView
        var linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rvOfficialAccount.run {
            adapter = homeAdapter
            layoutManager = linearLayoutManager
        }

        var tvMore = viewHolder.itemView.findViewById<View>(R.id.tv_more) as TextView
        tvMore.setOnClickListener {
            ArouterPageManger.navigation(context, ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_LIST_ACTIVITY)
        }
    }


    /**
     * Home Adapter
     */
    private val homeAdapter: OfficialAccountListAdapter by lazy {
        OfficialAccountListAdapter()
    }



    override fun convert(helper: BaseViewHolder, item: HomeListDataType) {
      val officialAccount = item as OfficialAccount
        homeAdapter.setList(officialAccount)
    }


}