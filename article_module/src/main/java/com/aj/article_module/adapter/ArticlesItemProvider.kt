package com.aj.article_module.adapter


import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.Article
import com.aj.article_module.bean.HomeListDataType
import com.aj.article_module.bean.ItemDataType
import com.aj.article_module.bean.PageDataInfo
import com.aj.article_module.databinding.ArticleItemArticlesBinding
import com.aj.base_module.utils.ContextCompatUtils
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlin.random.Random


/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      ArticlesItemProvider
 * @Description:    文章item
 * @Author:         zhy
 * @CreateDate:     2020/6/16 14:32
 */

class ArticlesItemProvider : BaseItemProvider<HomeListDataType>() {

    private val colors = intArrayOf(
        R.color.base_color_deep_gray,
        R.color.base_color_gray,
        R.color.base_color_757575,
        R.color.base_color_455A64,
        R.color.base_color_9E9E9E,
        R.color.base_color_BDBDBD
    )

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
        val articleDamaging: ArticleItemArticlesBinding? =
            DataBindingUtil.getBinding(helper.itemView)
        if (articleDamaging != null) {
            articleDamaging.article = article
        }
        val tvTab = helper.getView<View>(R.id.tv_tab)
        val gradientDrawable : GradientDrawable = tvTab.background as GradientDrawable
        gradientDrawable.setColor(ContextCompatUtils.getColor(context,colors[Random.nextInt(colors.size )]))


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
        bundle.putString(PageDataInfo.articleTitle,article.title)
        ArouterPageManger.navigationWithParams(context, ArouterUrlManage.ARTICLE_ARTICLE_DETAIL,bundle)

    }

}