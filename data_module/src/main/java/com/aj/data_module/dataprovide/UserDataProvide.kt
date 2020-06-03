package com.aj.data_module.dataprovide

import android.content.Context
import android.util.Log
import com.aj.data_module.bean.User
import com.aj.data_module.database.AppDataBase

/**
 * 对外提供数据库操作的数据类
 */
class UserDataProvide {

    var userDao =  AppDataBase.getDBInstace().userDao()
    fun addUser(username : String,password :String){

        var user =User(1,"d");
        userDao?.insertAll(user);
        userDao?.getAll().toString();

    }
}