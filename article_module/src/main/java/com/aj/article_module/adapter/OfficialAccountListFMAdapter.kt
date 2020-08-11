package com.aj.article_module.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.OfficialAccountItem
import com.aj.article_module.databinding.ArticleOfficialaccountItemBinding
import com.aj.article_module.databinding.ArticleOfficialaccountListItemBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlin.random.Random

/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      OfficialAccountListAdapter
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/8/03 11:12
 */

class OfficialAccountListFMAdapter : BaseQuickAdapter<OfficialAccountItem, BaseViewHolder> {
    private val colors = intArrayOf(
        R.color.article_colorPrimaryDark
    )

    constructor(layoutResId: Int = R.layout.article_officialaccount_list_item) : super(
        layoutResId
    )

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onItemViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: OfficialAccountItem) {
        // 获取 Binding
        var articleDamaging : ArticleOfficialaccountListItemBinding? =
            DataBindingUtil.getBinding(holder.itemView)
        if (articleDamaging != null) {
            articleDamaging.officialAccountItem = item
        }
        var  random = Random.nextInt(1)
        if (articleDamaging != null) {
            articleDamaging.color =holder.itemView.context.resources.getColor(colors[random])
        }
    }

}

