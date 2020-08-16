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
    const val DATA_MODULE = "/data_module"//数据模块
    const val ARTICLE_MODULE = "/article_module"//数据模块

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    const val SERVICE = "/service"

    /**
     *用户ui模块
     */
    const val USER_LOGINACTIVITY = USERUI + "/LoginActivity"
    const val USER_FRAGEMNT = USERUI + "/UserFragment"

    /**
     *文章ui模块
     */ 
    const val ARTICLE_ARTICLE_DETAIL = ARTICLE_MODULE + "/ArticleDetailActivity"
    const val ARTICLE_HOME_FRAGMENT = ARTICLE_MODULE + "/HomeFragment"
    const val ARTICLE_OFFICIAL_ACCOUNT_LIST_ACTIVITY = ARTICLE_MODULE + "/OfficialAccountListActivity"
    const val ARTICLE_OFFICIAL_ACCOUNT_LIST_FRAGMENT = ARTICLE_MODULE + "/OfficialAccountListFragment"
    const val ARTICLE_OFFICIAL_ACCOUNT_ARTICLE_LIST_ACTIVITY = ARTICLE_MODULE + "/OfficialAccountArticleListActivity"
    const val ARTICLE_OFFICIAL_ACCOUNT_ARTICLE_LIST_FRAGMENT = ARTICLE_MODULE + "/OfficialAccountArticleListFragment"
    const val ARTICLE_SYSTEM_FRAGMENT = ARTICLE_MODULE + "/SystemFragment"
    const val ARTICLE_PROJECT_FRAGMENT = ARTICLE_MODULE + "/PeojectFragment"
    const val ARTICLE_PROJECTLIST_FRAGMENT = ARTICLE_MODULE + "/PeojectListFragment"
    /**
     *数据模块
     */

    const val DATAMODULEUSERSERVICE = SERVICE + DATA_MODULE +   "/user";

}