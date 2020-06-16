package com.aj.article_module.adapter

import com.aj.article_module.R
import com.aj.article_module.bean.ItemDataType

import com.aj.article_module.bean.ListDataType
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

class HomeListAdapter : BaseProviderMultiAdapter<ListDataType>() , LoadMoreModule {


    init {
        // 注册 Provider
        addItemProvider(ArticlesItemProvider())
        addItemProvider(OfficialAccountItemProvider())
//        addItemProvider(TextImgItemProvider())
//        addItemProvider(TextItemProvider())
    }

    override fun getItemType(data: List<ListDataType>, position: Int): Int {
                when (position % 3) {
            0 -> return ItemDataType.Articles
            1 -> return ItemDataType.OfficialAccount
            else -> {
            }
        }
        return ItemDataType.Articles
    }

//    override fun getItemType(data: List<ListDataType?>, position: Int): Int {
////        when (position % 3) {
////            0 -> return ProviderMultiEntity.IMG
////            1 -> return ProviderMultiEntity.TEXT
////            2 -> return ProviderMultiEntity.IMG_TEXT
////            else -> {
////            }
////        }
//        return 0
//    }


}