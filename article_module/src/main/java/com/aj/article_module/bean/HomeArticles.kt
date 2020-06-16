package com.aj.article_module.bean

/**
 *
 * @Package:        com.aj.article_module.bean
 * @ClassName:      HomeArticles
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/6/15 10:44
 */

//文章
data class ArticleResponseBody(
    val curPage: Int,
    var datas: MutableList<Article>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

//文章
data class Article (
    val apkLink: String,
    val audit: Int,
    val author: String,
    val chapterId: Int,
    val chapterName: String,
    var collect: Boolean,
    val courseId: Int,
    val desc: String,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val shareDate: String,
    val shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: MutableList<Tag>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int,
    var top: String,
    var itemType : Int = ItemDataType.Articles
):ListDataType

data class Tag(
    val name: String,
    val url: String
)
