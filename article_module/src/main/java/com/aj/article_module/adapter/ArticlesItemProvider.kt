package com.aj.article_module.adapter


import com.aj.article_module.R
import com.aj.article_module.bean.Article
import com.aj.article_module.bean.ItemDataType
import com.aj.article_module.bean.ListDataType
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      ArticlesItemProvider
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/6/16 14:32
 */

class ArticlesItemProvider : BaseItemProvider<ListDataType>() {


    override fun convert(helper: BaseViewHolder, item: ListDataType) {
        val article = item as Article
        article.chapterId
        helper.setText(R.id.tv_test,article.title)
    }

    override val itemViewType: Int
        get() = ItemDataType.Articles
    override val layoutId: Int
        get() = R.layout.article_item_articles


}