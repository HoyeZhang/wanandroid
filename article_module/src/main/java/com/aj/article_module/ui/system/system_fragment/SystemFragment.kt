package com.aj.article_module.ui.system.system_fragment

import android.text.Html
import androidx.lifecycle.Observer
import com.aj.article_module.R
import com.aj.article_module.adapter.ViewPagerAdapter
import com.aj.article_module.ui.system.system_classify_fragment.SystemClassifyFragment
import com.aj.base_module.ui.fragment.BaseVMFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import kotlinx.android.synthetic.main.article_layout_project_fragment.*


/**
 * @author zhy
 * @time 2020/8/16.
 */
@Route(path = ArouterUrlManage.ARTICLE_SYSTEM_FRAGMENT)
class SystemFragment : BaseVMFragment() {
    private var mediator : TabLayoutMediator? = null
    override fun getLayoutRes(): Int = R.layout.article_layout_project_fragment

    private val mViewModel by lazy {
        initViewModel(
            this, SystemFmViewModel::class, SystemFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun initView() {
        mViewModel.systemTreeBean.observe(this, Observer {
            val titles = arrayListOf<String>()
            val fragments = arrayListOf<BaseVMFragment>()

            for (systemTreeItem in it) {
                titles.add(Html.fromHtml(systemTreeItem.name).toString())
                fragments.add(SystemClassifyFragment.newInstance(systemTreeItem))
            }

            val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle,fragments)

            vp_project.offscreenPageLimit = it.size
            vp_project.adapter = viewPagerAdapter
            projectTabLayout.tabMode = TabLayout.MODE_SCROLLABLE

             mediator = TabLayoutMediator(projectTabLayout, vp_project,
                TabConfigurationStrategy { tab, position -> //这里可以自定义TabView
                    tab.text = titles[position]
                })
            //要执行这一句才是真正将两者绑定起来
            mediator!!.attach()

        })
    }

    override fun initData() {
        super.initData()
        mViewModel.getProjectTree()
    }

}