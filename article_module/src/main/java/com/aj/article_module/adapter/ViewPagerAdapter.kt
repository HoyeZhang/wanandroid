package com.aj.article_module.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aj.base_module.ui.fragment.BaseVMFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,fragments : List<BaseVMFragment>) : FragmentStateAdapter(fragmentManager, lifecycle) {
    private var mFragments : List<BaseVMFragment> = fragments

    override fun getItemCount(): Int {

        return mFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragments[position]
    }

}