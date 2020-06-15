package com.aj.article_module.ui.homefragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aj.base_module.ui.viewmodel.BaseViewModel



class HomeFmViewModel(private val repository: HomeFmRepository) : BaseViewModel() {

    fun getArticles(num :Int) {

        launch {
           Log.d("dad", repository.getArticles(num).data.toString());
            repository.getArticles(num).data.toString()
        }
    }
}