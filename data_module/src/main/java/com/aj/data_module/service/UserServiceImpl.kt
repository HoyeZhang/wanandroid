package com.aj.data_module.service

import android.content.Context
import android.util.Log
import com.aj.data_module.dataprovide.UserDataProvide
import com.aj.data_service.Service.UserService
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/dataservice/user", name = "用户服务")
class UserServiceImpl : UserService {
    override fun addUser(userJson: String) {
        Log.d("daadaddada","dadasdadasdaddas")
        var userdao = UserDataProvide()
        userdao.addUser("dfa","dad");
        Log.d("daadad","dadasdadasdaddas")
    }

    override fun init(context: Context?) {

    }

}