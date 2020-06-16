package com.aj.article_module.bean

/**
 *
 * @Package:        com.aj.article_module.bean
 * @ClassName:      OfficialAccount
 * @Description:     公众号
 * @Author:         zhy
 * @CreateDate:     2020/6/16 20:18
 */

class OfficialAccount(var itemType : Int = ItemDataType.OfficialAccount) : ArrayList<OfficialAccountItem>(),ListDataType

data class OfficialAccountItem(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)


