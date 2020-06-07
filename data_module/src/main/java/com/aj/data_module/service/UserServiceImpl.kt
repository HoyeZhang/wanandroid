package com.aj.data_module.service

import android.content.Context
import android.util.Log
import com.aj.data_module.dataprovide.UserDataProvide
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.UserService
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = ArouterUrlManage.DATAMODULEUSERSERVICE, name = "用户服务")
class UserServiceImpl : UserService {
    override fun addUser(username: String,password :String) {

        var userdao = UserDataProvide()
        userdao.addUser(username, password);
    }

    override fun init(context: Context?) {

    }

}