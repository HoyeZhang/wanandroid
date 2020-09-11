package com.aj.data_service.Service

import com.alibaba.android.arouter.facade.template.IProvider

/**
 *
 * @Package:        com.aj.data_service.Service
 * @ClassName:      LoginService
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/9/11 14:55
 */
interface LoginService : IProvider {
    fun userLogin(username: String?, password: String?)
}