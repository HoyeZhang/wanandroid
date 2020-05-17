package com.aj.user_module.ui.login

import androidx.lifecycle.MutableLiveData
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.user_module.bean.LoginBean

class LoginViewModel(private val repository: LoginRepository) : BaseViewModel() {
    var loginBean = MutableLiveData<LoginBean>()

    fun login(username: String, password: String) {
        launch({
            loginBean.value = repository.login(username, password)

        });
    }
}