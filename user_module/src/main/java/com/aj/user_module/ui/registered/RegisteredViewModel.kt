package com.aj.user_module.ui.registered

import androidx.lifecycle.MutableLiveData
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.UserService
import com.aj.user_module.bean.LoginBean
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter


class RegisteredViewModel(private val repository: RegisteredRepository) : BaseViewModel() {
    var loginBean = MutableLiveData<LoginBean>()
    var registeredBean = MutableLiveData<LoginBean>()

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

    fun registered(username: String, password: String) {
        ARouter.getInstance().inject(this);
        launch {
            registeredBean.value = repository.registered(username, password).data
            // TODO: 2020/9/7 自动登录 
        }
    }
}