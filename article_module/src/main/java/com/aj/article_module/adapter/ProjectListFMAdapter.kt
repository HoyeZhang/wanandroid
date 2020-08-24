package com.aj.article_module.adapter

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.article_module.R
import com.aj.article_module.bean.OfficialAccountItem
import com.aj.article_module.bean.PageDataInfo
import com.aj.article_module.bean.ProjectDataItem
import com.aj.article_module.databinding.ArticleOfficialaccountListItemBinding
import com.aj.article_module.databinding.ArticleProjectListItemBinding
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
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

class ProjectListFMAdapter : BaseQuickAdapter<ProjectDataItem, BaseViewHolder>, LoadMoreModule {


    constructor(layoutResId: Int = R.layout.article_project_list_item) : super(
        layoutResId
    )

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onItemViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: ProjectDataItem) {
        // 获取 Binding
        var articleProjectListItemBinding : ArticleProjectListItemBinding? =
            DataBindingUtil.getBinding(holder.itemView)
        if (articleProjectListItemBinding != null) {
            articleProjectListItemBinding.projectDataItem = item
        }


        val clBg = holder.getView<View>(R.id.cl_bg)

        clBg.setOnClickListener {
            var bundle = Bundle()
            bundle.putString(PageDataInfo.articleUrl,item.link)
            bundle.putString(PageDataInfo.articleTitle,item.title)
            ArouterPageManger.navigationWithParams(context, ArouterUrlManage.ARTICLE_ARTICLE_DETAIL,bundle)
        }
    }

}

