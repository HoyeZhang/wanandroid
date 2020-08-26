package com.aj.ui.init

import android.content.Context
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.AppContextService
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter

/**
 *
 * @Package:        com.aj.ui.init
 * @ClassName:      InitServiceContext
 * @Description:    初始化数据模块的context
 * @Author:         zhy
 * @CreateDate:     2020/8/26 11:49
 */
class InitDataModuleContext(context: Context) {
    @Autowired(name = ArouterUrlManage.DATAMODULEAPPCONTEXTSERVICE)
    @JvmField
    var appContextService: AppContextService? = null

    init {
        ARouter.getInstance().inject(this)
        appContextService?.setAppContext(context)
    }
}