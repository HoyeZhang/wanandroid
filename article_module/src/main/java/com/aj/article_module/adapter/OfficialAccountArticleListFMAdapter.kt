package com.aj.article_module.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.Article
import com.aj.article_module.bean.ArticleResponseBody
import com.aj.article_module.bean.OfficialAccountItem
import com.aj.article_module.databinding.ArticleItemArticlesBinding
import com.aj.article_module.databinding.ArticleOfficialaccountItemBinding
import com.aj.article_module.databinding.ArticleOfficialaccountListItemBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
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

class OfficialAccountArticleListFMAdapter : BaseQuickAdapter<Article, BaseViewHolder>,
    LoadMoreModule {
    private val colors = intArrayOf(
        R.color.article_colorPrimaryDark
    )

    constructor(layoutResId: Int = R.layout.article_item_articles) : super(
        layoutResId
    )

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onItemViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: Article) {
        // 获取 Binding
        var articleDamaging : ArticleItemArticlesBinding? =
            DataBindingUtil.getBinding(holder.itemView)
        if (articleDamaging != null) {
            articleDamaging.article = item
        }

    }

}

