package com.aj.user_module.service_provide

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.LoginService
import com.aj.user_module.bean.LoginBean
import com.aj.user_module.ui.login.LoginRepository
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 *
 * @Package:        com.aj.user_module.service_provide
 * @ClassName:      LoginServiceImpl
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/9/11 14:57
 */
@Route(path = ArouterUrlManage.USER_LOGIN_SERVICE, name = "用户登录")
class LoginServiceImpl : LoginService {
    var loginBean = MutableLiveData<LoginBean>()

    override  fun userLogin(username: String?, password: String?) {
        var loginRepository : LoginRepository = LoginRepository()

        GlobalScope.async {
            try {
                if (username != null && password != null) {
                    loginBean.value =  loginRepository.login(username,password).data
                }else{

                }

            } catch (e: Exception) {
                return@async  Log.d("","LoginERROR")
            }
        }

    }

    override fun init(context: Context?) {

    }

}