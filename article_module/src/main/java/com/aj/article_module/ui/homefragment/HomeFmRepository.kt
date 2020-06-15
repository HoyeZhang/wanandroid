package com.aj.article_module.ui.homefragment


import com.aj.article_module.apis.WanAndroidApis
import com.aj.base_module.net.BaseRepository
import com.aj.base_module.net.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeFmRepository : BaseRepository() {
    suspend fun getArticles(num :Int) = withContext(Dispatchers.IO) {
        RetrofitManager.create(WanAndroidApis::class.java).getArticles(num).await()
    }
}