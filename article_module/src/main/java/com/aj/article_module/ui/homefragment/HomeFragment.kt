package com.aj.article_module.ui.homefragment

import android.os.Parcel
import android.os.Parcelable
import com.aj.article_module.R
import com.aj.base_module.ui.fragment.BaseDataBindVMFragment
import com.aj.base_module.ui.fragment.BaseListPageFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage


import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @author zhy
 * @time 2020/6/14.
 */
@Route(path = ArouterUrlManage.ARYTICLE_HOME_FRAGEMNT)
class HomeFragment : BaseListPageFragment<HomeFmViewModel>() {

    private val mViewModel by lazy {
        initViewModel(
            this, HomeFmViewModel::class, HomeFmRepository::class
        )
    }
    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }




    override fun initRecyclerView() {

    }

    override fun getListData() {

    }
}