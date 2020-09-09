package com.aj.data_service.Service

import com.aj.data_service.bean.DataUser
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * 用户相关数据操作
 */

interface UserService : IProvider {
   fun addUser(userName :String,password:String)

   fun queryAll()

   fun queryLoginUser() : DataUser?

   fun clearLoginUser()
}