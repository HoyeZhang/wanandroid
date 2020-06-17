package com.aj.article_module.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.OfficialAccountItem
import com.aj.article_module.databinding.ArticleOfficialaccountItemBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      OfficialAccountListAdapter
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/6/17 11:12
 */

class OfficialAccountListAdapter : BaseQuickAdapter<OfficialAccountItem, BaseViewHolder> {

    constructor(layoutResId: Int = R.layout.article_officialaccount_item) : super(
        layoutResId
    )

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onItemViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: OfficialAccountItem) {
        // 获取 Binding
        var articleDamaging : ArticleOfficialaccountItemBinding? =
            DataBindingUtil.getBinding(holder.itemView)
        if (articleDamaging != null) {
            articleDamaging.officialAccountItem = item
        }
    }

}

