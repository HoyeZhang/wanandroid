package com.aj.article_module.ui.project.project_fragment


import com.aj.article_module.apis.WanAndroidApis
import com.aj.base_module.net.BaseRepository
import com.aj.base_module.net.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProjectFmRepository : BaseRepository() {



    suspend fun getProjectTree() = withContext(Dispatchers.IO) {
        RetrofitManager.create(WanAndroidApis::class.java).getProjectTree().await()
    }
}