package com.aj.data_service.Service

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * 用户相关数据操作
 */

interface UserService : IProvider {
   fun addUser(userName :String,password:String)

}