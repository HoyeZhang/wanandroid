package com.aj.article_module.adapter

import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.*
import com.aj.article_module.databinding.ArticleItemSystemTreeItemBinding
import com.aj.base_module.utils.ContextCompatUtils
import com.aj.base_module.utils.ScreenUtils
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.chad.library.adapter.base.BaseQuickAdapter

import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.flexbox.FlexboxLayout

/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      OfficialAccountListAdapter
 * @Description:    体系列表
 * @Author:         zhy
 * @CreateDate:     2020/8/03 11:12
 */

class SystemTreeFMAdapter : BaseQuickAdapter<SystemTreeBean, BaseViewHolder> {

    constructor(layoutResId: Int = R.layout.article_item_system_tree_item) : super(
        layoutResId
    )

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onItemViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
        setOnItemClickListener { _, _, position ->
            val bundle = Bundle()
            bundle.putString(PageDataInfo.systemTreeName, data[position].name)
            bundle.putParcelable(PageDataInfo.systemTreeBean, data[position])
            ArouterPageManger.navigationWithParams(
                context,
                ArouterUrlManage.ARTICLE_SYSTEM_CLASSIFY_ACTIVITY,
                bundle
            )
        }
    }

    override fun convert(holder: BaseViewHolder, item: SystemTreeBean) {
        //获取 Binding
        val articleItemSystemTreeItemBinding: ArticleItemSystemTreeItemBinding? =
            DataBindingUtil.getBinding(holder.itemView)
        if (articleItemSystemTreeItemBinding != null) {
            articleItemSystemTreeItemBinding.systemTreeBean = item
        }
        var flexLayout: FlexboxLayout = holder.getView(R.id.fbl_tab)
        if (item.children != null && item.children.isNotEmpty()) {
            flexLayout.removeAllViews()
            item.children.forEach { systemTreeChildren ->
                val tabItem = TextView(context)
                tabItem.text = systemTreeChildren.name
                tabItem.setTextSize(
                    TypedValue.COMPLEX_UNIT_PX,
                    context.resources.getDimension(R.dimen.base_text_sp_14)
                )
                tabItem.background = ContextCompatUtils.getDrawable(context,R.drawable.article_bg_theme_round_2)
                var vlp: FlexboxLayout.LayoutParams = FlexboxLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                vlp.setMargins(
                    ScreenUtils.dp2px(context, 1f),
                    ScreenUtils.dp2px(context, 1f),
                    ScreenUtils.dp2px(context, 1f),
                    ScreenUtils.dp2px(context, 1f)
                )
                tabItem.setPadding(
                    ScreenUtils.dp2px(context, 1f),
                    ScreenUtils.dp2px(context, 1f),
                    ScreenUtils.dp2px(context, 1f),
                    ScreenUtils.dp2px(context, 1f)
                )
                tabItem.layoutParams = vlp
                flexLayout.addView(tabItem)
            }
        }
    }

}

