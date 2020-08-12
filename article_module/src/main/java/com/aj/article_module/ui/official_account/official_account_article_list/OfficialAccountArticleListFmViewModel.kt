package com.aj.article_module.ui.official_account.official_account_article_list

import androidx.lifecycle.MutableLiveData
import com.aj.article_module.bean.Article

import com.aj.base_module.ui.viewmodel.BaseViewModel

/**
 *
 * @Package:        com.aj.article_module.ui.official_account.official_account_article_list
 * @ClassName:      OfficialAccountArticleListFmViewModel
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/7/31 15:37
 */
class OfficialAccountArticleListFmViewModel(private val repository: OfficialAccountArticleListFmRepository) : BaseViewModel() {

    var articleList = MutableLiveData<List<Article>>()

    fun getOfficialAccountArticleList(accountId: Int,num :Int) {
        launch {
            articleList.value = repository.getOfficialAccountArticleList(accountId, num).data.datas

        }
    }
}