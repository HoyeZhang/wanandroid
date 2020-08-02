package com.aj.article_module.ui.official_account.official_account_list

import androidx.lifecycle.MutableLiveData
import com.aj.article_module.bean.Article
import com.aj.article_module.bean.OfficialAccount
import com.aj.article_module.ui.homefragment.HomeFmRepository
import com.aj.base_module.ui.viewmodel.BaseViewModel

/**
 *
 * @Package:        com.aj.article_module.ui.official_account.official_account_list
 * @ClassName:      OfficialAccountListFmViewModel
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/7/31 15:37
 */
class OfficialAccountListFmViewModel(private val repository: OfficialAccountListFmRepository) : BaseViewModel() {

    var officialAccount = MutableLiveData<OfficialAccount>()

    fun getWxArticle() {
        launch {
            officialAccount.value = repository.getWxArticle().data
        }
    }
}