package com.aj.article_module.ui.search


import com.aj.article_module.apis.WanAndroidApis
import com.aj.base_module.net.BaseRepository
import com.aj.base_module.net.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class SearchFmRepository : BaseRepository() {
    suspend fun search(pageNum: Int,k :String) = withContext(Dispatchers.IO) {
        RetrofitManager.create(WanAndroidApis::class.java).search(pageNum,k).await()
    }
}