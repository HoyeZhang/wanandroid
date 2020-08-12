package com.aj.article_module.ui.official_account.official_account_article_list


import com.aj.article_module.apis.WanAndroidApis
import com.aj.base_module.net.BaseRepository
import com.aj.base_module.net.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * @Package:        com.aj.article_module.ui.official_account.official_account_article_list
 * @ClassName:      OfficialAccountArticleListFmRepository
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/7/31 15:37
 */
class OfficialAccountArticleListFmRepository : BaseRepository() {
    suspend fun getOfficialAccountArticleList(accountId: Int,num :Int) = withContext(Dispatchers.IO) {
        RetrofitManager.create(WanAndroidApis::class.java).getOfficialAccountArticleList(accountId,num).await()
    }
}