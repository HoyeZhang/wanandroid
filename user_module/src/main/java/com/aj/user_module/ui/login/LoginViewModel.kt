package com.aj.user_module.ui.login

import androidx.lifecycle.MutableLiveData
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.UserService
import com.aj.user_module.bean.LoginBean
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter


class LoginViewModel(private val repository: LoginRepository) : BaseViewModel() {
    var loginBean = MutableLiveData<LoginBean>()


    @Autowired(name = ArouterUrlManage.DATAMODULEUSERSERVICE)
    @JvmField
    var userService: UserService? = null

    fun login(username: String, password: String) {
        ARouter.getInstance().inject(this);
        launch {
            loginBean.value = repository.login(username, password).data

            userService?.addUser(username,password)

        }
    }
}