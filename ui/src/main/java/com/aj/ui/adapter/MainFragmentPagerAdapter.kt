package com.aj.ui.adapter

import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aj.base_module.ui.activity.BaseActivity
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage



/**
 * @author zhy
 * @time 2020/6/14.
 */
class AdapterFragmentPager(fragmentActivity: BaseActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments: SparseArray<Fragment> = SparseArray()
    init {
        val userFragment = ArouterPageManger.navigationForResult(ArouterUrlManage.USER_FRAGEMNT) as Fragment
        val userFragment1 = ArouterPageManger.navigationForResult(ArouterUrlManage.ARYTICLE_HOME_FRAGEMNT) as Fragment
        val userFragment2 = ArouterPageManger.navigationForResult(ArouterUrlManage.USER_FRAGEMNT) as Fragment

        fragments.put(PAGE_HOME,userFragment  )
        fragments.put(PAGE_FIND,userFragment1 )
        fragments.put(PAGE_INDICATOR,userFragment2 )
//        fragments.put(PAGE_OTHERS,userFragment )
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size()
    }

    companion object {

        const val PAGE_HOME = 0

        const val PAGE_FIND = 1

        const val PAGE_INDICATOR = 2

        const val PAGE_OTHERS = 3

    }
}