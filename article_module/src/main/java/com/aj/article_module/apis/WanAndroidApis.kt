package com.aj.article_module.apis

/**
 *
 * @Package:        com.aj.article_module.apis
 * @ClassName:      WanAndroidApis
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/6/15 10:33
 */

import com.aj.article_module.bean.ArticleResponseBody
import com.aj.article_module.bean.OfficialAccount
import com.aj.article_module.bean.ProjectTreeBean
import com.aj.base_module.net.BaseResponse


import retrofit2.Call
import retrofit2.http.*

interface WanAndroidApis {

    /**
     * 获取首页文章
     */
    @GET("article/list/{pageNum}/json")
    fun getArticles(@Path("pageNum") pageNum: Int): Call<BaseResponse<ArticleResponseBody>>

    /**
     * 获取公众号列表
     */
    @GET("wxarticle/chapters/json")
    fun getWxArticle(): Call<BaseResponse<OfficialAccount>>

    /**
     * 获取公众号文章
     */
    @GET("wxarticle/list/{accountId}/{pageNum}/json")
    fun getOfficialAccountArticleList(@Path("accountId") accountId: Int,@Path("pageNum") pageNum: Int): Call<BaseResponse<ArticleResponseBody>>

    /**
     * 获取项目分类
     */
    @GET("project/tree/json")
    fun getProjectTree(): Call<BaseResponse<List<ProjectTreeBean>>>
}