package com.aj.article_module.ui.project.projectlist_fragment


import com.aj.article_module.apis.WanAndroidApis
import com.aj.base_module.net.BaseRepository
import com.aj.base_module.net.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SystemListFmRepository : BaseRepository() {
    suspend fun getSystemTreeArticle(num :Int,id : Int) = withContext(Dispatchers.IO) {
        RetrofitManager.create(WanAndroidApis::class.java).getSystemTreeArticle(num,id).await()
    }
}