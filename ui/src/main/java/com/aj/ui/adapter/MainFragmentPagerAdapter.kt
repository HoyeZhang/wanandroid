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
class AdapterFragmentPager(fragmentActivity: BaseActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments: SparseArray<Fragment> = SparseArray()

    init {
        val homeFragment =
            ArouterPageManger.navigationForResult(ArouterUrlManage.ARTICLE_HOME_FRAGMENT) as Fragment
        val systemFragment =
            ArouterPageManger.navigationForResult(ArouterUrlManage.ARTICLE_SYSTEM_FRAGMENT) as Fragment
        val projectFragment =
            ArouterPageManger.navigationForResult(ArouterUrlManage.ARTICLE_PROJECT_FRAGMENT) as Fragment
        val userFragment =
            ArouterPageManger.navigationForResult(ArouterUrlManage.USER_FRAGEMNT) as Fragment
        fragments.put(PAGE_HOME, homeFragment)
        fragments.put(PAGE_SYSTEM, systemFragment)
        fragments.put(PAGE_PROJECT, projectFragment)
        fragments.put(PAGE_MINE, userFragment)
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size()
    }

    companion object {

        const val PAGE_HOME = 0

        const val PAGE_SYSTEM = 1

        const val PAGE_PROJECT = 2

        const val PAGE_MINE = 3

    }
}