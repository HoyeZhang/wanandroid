package com.aj.article_module.bean

/**
 * @author zhy
 * @time 2020/8/16.
 */
data class ProjectTreeBean(val visible: Int = 0,
                               val name: String = "",
                               val userControlSetTop: Boolean = false,
                               val id: Int = 0,
                               val courseId: Int = 0,
                               val parentChapterId: Int = 0,
                               val order: Int = 0)