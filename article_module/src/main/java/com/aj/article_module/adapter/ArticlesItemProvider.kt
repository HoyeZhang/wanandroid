package com.aj.article_module.adapter


import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.Article
import com.aj.article_module.bean.HomeListDataType
import com.aj.article_module.bean.ItemDataType
import com.aj.article_module.bean.PageDataInfo

import com.aj.article_module.databinding.ArticleItemArticlesBinding
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
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

class ArticlesItemProvider : BaseItemProvider<HomeListDataType>() {

    override val itemViewType: Int
        get() = ItemDataType.Articles
    override val layoutId: Int
        get() = R.layout.article_item_articles

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeListDataType) {
        val article = item as Article
        // 获取 Binding
        var articleDamaging: ArticleItemArticlesBinding? =
            DataBindingUtil.getBinding(helper.itemView)
        if (articleDamaging != null) {
            articleDamaging.article = article
        }

    }


    override fun onClick(
        helper: BaseViewHolder,
        view: View,
        data: HomeListDataType,
        position: Int
    ) {
        super.onClick(helper, view, data, position)
        val article = data as Article
        var bundle = Bundle()
        bundle.putString(PageDataInfo.articleUrl,article.link)
        ArouterPageManger.navigationWithParams(context, ArouterUrlManage.ARYTICLE_ARTICLEDETAIL,bundle)

    }

}