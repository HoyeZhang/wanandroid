package com.aj.article_module.ui.system.system_fragment


import com.aj.article_module.apis.WanAndroidApis
import com.aj.base_module.net.BaseRepository
import com.aj.base_module.net.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SystemFmRepository : BaseRepository() {
    suspend fun getArticles(num :Int) = withContext(Dispatchers.IO) {
        RetrofitManager.create(WanAndroidApis::class.java).getArticles(num).await()
    }

    suspend fun getWxArticle() = withContext(Dispatchers.IO) {
        RetrofitManager.create(WanAndroidApis::class.java).getWxArticle().await()
    }
}