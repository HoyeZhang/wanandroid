package com.aj.article_module.adapter


import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aj.article_module.R
import com.aj.article_module.bean.*

import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.chad.library.adapter.base.BaseQuickAdapter

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
        val rvOfficialAccount = viewHolder.itemView.findViewById<View>(R.id.rv_official_account) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rvOfficialAccount.run {
            adapter = accountListAdapter
            layoutManager = linearLayoutManager
        }

        val tvMore = viewHolder.itemView.findViewById<View>(R.id.tv_more) as TextView
        tvMore.setOnClickListener {
            ArouterPageManger.navigation(context, ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_LIST_ACTIVITY)
        }
    }


    /**
     * Home Adapter
     */
    private val accountListAdapter: OfficialAccountListAdapter by lazy {
        OfficialAccountListAdapter()
    }



    override fun convert(helper: BaseViewHolder, item: HomeListDataType) {
      val officialAccount = item as OfficialAccount
        accountListAdapter.setList(officialAccount)
        accountListAdapter.setOnItemClickListener { _, _,  position ->
            val bundle = Bundle()
            bundle.putInt(PageDataInfo.officialAccountId,officialAccount[position].id)
            bundle.putString(PageDataInfo.officialAccountName,officialAccount[position].name)
            ArouterPageManger.navigationWithParams(context, ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_ARTICLE_LIST_ACTIVITY,bundle)
        }
    }


}