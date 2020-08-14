package com.aj.article_module.adapter

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.OfficialAccountItem
import com.aj.article_module.bean.PageDataInfo
import com.aj.article_module.databinding.ArticleOfficialaccountListItemBinding
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
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
        R.color.base_color_cyan,
        R.color.base_color_deep_gray,
        R.color.base_colorAccent
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

        setOnItemClickListener { _, _, _ ->
            val bundle = Bundle()
            bundle.putInt(PageDataInfo.officialAccountId,item.id)
            ArouterPageManger.navigationWithParams(context, ArouterUrlManage.ARTICLE_OFFICIAL_ACCOUNT_ARTICLE_LIST_ACTIVITY,bundle)
        }

        val llBg = holder.getView<View>(R.id.ll_bg)
        val gradientDrawable : GradientDrawable = llBg.background as GradientDrawable
        gradientDrawable.setColor(ContextCompat.getColor(context,colors[Random.nextInt(colors.size )]))

        val params = llBg.layoutParams

        params.width = LinearLayout.LayoutParams.MATCH_PARENT
        params.height = 200 + Random.nextInt(150)
    }

}

