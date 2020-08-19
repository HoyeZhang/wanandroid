package com.aj.article_module.ui.project.projectlist_fragment


import androidx.lifecycle.MutableLiveData
import com.aj.article_module.bean.Article

import com.aj.article_module.bean.ProjectDataItem

import com.aj.base_module.ui.viewmodel.BaseViewModel


class SystemListFmViewModel(private val repository: SystemListFmRepository) : BaseViewModel() {

    var articleList = MutableLiveData<List<Article>>()


    fun getSystemTreeArticle(num :Int,id : Int) {
        launch {
            articleList.value = repository.getSystemTreeArticle(num,id).data.datas
        }
    }
}