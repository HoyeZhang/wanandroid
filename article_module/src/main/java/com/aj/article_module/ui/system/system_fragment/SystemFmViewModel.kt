package com.aj.article_module.ui.system.system_fragment


import androidx.lifecycle.MutableLiveData
import com.aj.article_module.bean.Article

import com.aj.article_module.bean.OfficialAccount
import com.aj.article_module.bean.ProjectTreeBean
import com.aj.article_module.bean.SystemTreeBean
import com.aj.base_module.ui.viewmodel.BaseViewModel



class SystemFmViewModel(private val repository: SystemFmRepository) : BaseViewModel() {
    var systemTreeBean = MutableLiveData<List<SystemTreeBean>>()

    fun getProjectTree() {
        launch {
            systemTreeBean.value =  repository.getSystemTree().data
        }
    }

}