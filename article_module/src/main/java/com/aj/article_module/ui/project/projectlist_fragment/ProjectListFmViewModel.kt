package com.aj.article_module.ui.project.projectlist_fragment


import androidx.lifecycle.MutableLiveData
import com.aj.article_module.bean.Article

import com.aj.article_module.bean.OfficialAccount
import com.aj.article_module.bean.ProjectBean
import com.aj.article_module.bean.ProjectDataItem

import com.aj.base_module.ui.viewmodel.BaseViewModel


class ProjectListFmViewModel(private val repository: ProjectListFmRepository) : BaseViewModel() {

    var projectList = MutableLiveData<List<ProjectDataItem>>()


    fun getProjectListByid(num :Int,id : Int) {
        launch {
            projectList.value = repository.getProjectListByid(num,id).data.datas
        }
    }
}