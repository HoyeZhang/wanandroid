package com.aj.data_service.Service

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author zhy
 * @time 2020/6/14.
 */
interface UserFmService : IProvider {
    fun getUserFm(userName :String,password:String) :Fragment

}