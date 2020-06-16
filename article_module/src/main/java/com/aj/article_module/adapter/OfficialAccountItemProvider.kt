package com.aj.article_module.adapter


import com.aj.article_module.R
import com.aj.article_module.bean.Article
import com.aj.article_module.bean.ItemDataType
import com.aj.article_module.bean.ListDataType
import com.aj.article_module.bean.OfficialAccount
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

class OfficialAccountItemProvider : BaseItemProvider<ListDataType>() {


    override fun convert(helper: BaseViewHolder, item: ListDataType) {

    }

    override val itemViewType: Int
        get() = ItemDataType.OfficialAccount
    override val layoutId: Int
        get() = R.layout.article_item_officialaccount


}