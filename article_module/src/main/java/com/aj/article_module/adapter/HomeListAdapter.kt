package com.aj.article_module.adapter

import com.aj.article_module.R
import com.aj.article_module.bean.HomeListDataType
import com.aj.article_module.bean.ItemDataType


import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.chad.library.adapter.base.module.LoadMoreModule


/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      HomeListAdapter
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/6/16 14:24
 */

class HomeListAdapter : BaseProviderMultiAdapter<HomeListDataType>(), LoadMoreModule {


    init {
        // 注册 Provider
        addItemProvider(ArticlesItemProvider())
        addItemProvider(OfficialAccountItemProvider())
    }

    override fun getItemType(data: List<HomeListDataType>, position: Int): Int {
        when (data[position].dataType) {
            ItemDataType.Articles -> return ItemDataType.Articles
            ItemDataType.OfficialAccount -> return ItemDataType.OfficialAccount
            else -> {
            }
        }
        return ItemDataType.Articles
    }

}