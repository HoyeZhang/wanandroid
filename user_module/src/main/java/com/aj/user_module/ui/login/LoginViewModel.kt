package com.aj.user_module.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.data_module.database.AppDataBase
import com.aj.data_module.dataprovide.UserDataProvide
import com.aj.user_module.bean.LoginBean

class LoginViewModel(private val repository: LoginRepository) : BaseViewModel() {
    var loginBean = MutableLiveData<LoginBean>()

    fun login(username: String, password: String) {
        launch {
            loginBean.value = repository.login(username, password).data
            Log.d("dfa",loginBean.toString())

            var userdao = UserDataProvide();
            userdao.addUser("dfa","dad");
        }
    }
}