package com.aj.data_service

/**
 * @author zhy
 * @time 2020/6/7.
 * 路由地址统一管理类
 */
object ArouterUrlManage {
    /**
     * 组名
     */
    const val APP = "/app"//宿主 App 组件
    const val USERUI = "/userui"//用户ui
    const val DATAMODULE = "/data_module"//数据模块

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    const val SERVICE = "/service"

    /**
     *用户ui模块
     */
    const val USER_LOGINACTIVITY = USERUI + "/LoginActivity"


    /**
     *数据模块
     */

    const val DATAMODULEUSERSERVICE = DATAMODULE + "/user";

}