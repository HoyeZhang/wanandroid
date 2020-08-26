package com.aj.data_module.dataprovide

import android.util.Log
import com.aj.data_module.bean.User
import com.aj.data_module.database.AppDataBase

/**
 * 对外提供数据库操作的数据类
 */
class UserDataProvide {

    private var userDao =  AppDataBase.getDBInstance().userDao()
    fun addUser(username : String,password :String){
        var user =User(username = username,password = password,isLogin = 1)
        userDao?.insertUser(user)
    }

    fun queryAll() :List<User?>?{
       return userDao?.queryAll()
    }

    fun queryLoginUser() :User?{
        return userDao?.queryLoginUser()
    }
}