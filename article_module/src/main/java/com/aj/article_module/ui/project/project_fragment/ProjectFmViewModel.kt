package com.aj.article_module.ui.project.project_fragment


import androidx.lifecycle.MutableLiveData
import com.aj.article_module.bean.ProjectTreeBean


import com.aj.base_module.ui.viewmodel.BaseViewModel


class ProjectFmViewModel(private val repository: ProjectFmRepository) : BaseViewModel() {
    var projectTreeBean = MutableLiveData<List<ProjectTreeBean>>()

    fun getProjectTree() {
        launch {
            projectTreeBean.value =  repository.getProjectTree().data
        }
    }


}