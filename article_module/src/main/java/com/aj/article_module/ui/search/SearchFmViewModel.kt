package com.aj.article_module.ui.search


import androidx.lifecycle.MutableLiveData
import com.aj.article_module.bean.Article

import com.aj.base_module.ui.viewmodel.BaseViewModel



class SearchFmViewModel(private val repository: SearchFmRepository) : BaseViewModel() {
    var articleList = MutableLiveData<List<Article>>()
    fun search(pageNum: Int,k :String) {
        launch {
            articleList.value = repository.search(pageNum, k).data.datas

        }
    }
}