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
    const val USER_REGISTERED_ACTIVITY = USERUI + "/RegisteredActivity"
    const val USER_FRAGEMNT = USERUI + "/UserFragment"
    const val USER_ABOUTACTIVITY = USERUI + "/AboutActivity"
    const val USER_ABOUTFRAGEMNT = USERUI + "/AboutFragment"

    /**
     *用户ui模块提供的服务
     */
    const val USER_LOGIN_SERVICE = USERUI + SERVICE + "/LoginService"

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
    const val ARTICLE_PROJECT_LIST_FRAGMENT = ARTICLE_MODULE + "/ProjectListFragment"
    const val ARTICLE_SYSTEM_CLASSIFY_FRAGMENT = ARTICLE_MODULE + "/SystemClassifyFragment"
    const val ARTICLE_SYSTEM_LIST_FRAGMENT = ARTICLE_MODULE + "/SystemListFragment"
    const val ARTICLE_SYSTEM_CLASSIFY_ACTIVITY = ARTICLE_MODULE + "/SystemClassifyActivity"
    const val ARTICLE_SEARCH_ACTIVITY = ARTICLE_MODULE + "/SearchActivity"
    const val ARTICLE_SEARCH_FRAGMENT = ARTICLE_MODULE + "/SearchFragment"
    /**
     *数据模块
     */

    const val DATAMODULEUSERSERVICE = SERVICE + DATA_MODULE +   "/user";

    const val DATAMODULEAPPCONTEXTSERVICE = SERVICE + DATA_MODULE +   "/appContext";

    const val  DATAMODULESHAREPREFERENCESSERVICE = SERVICE + DATA_MODULE +   "/SharePreferences";

}