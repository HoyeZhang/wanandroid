package com.aj.article_module.ui.project.project_fragment

import android.text.Html
import androidx.lifecycle.Observer
import com.aj.article_module.R
import com.aj.article_module.adapter.ViewPagerAdapter
import com.aj.article_module.ui.project.projectlist_fragment.ProjectListFragment
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
@Route(path = ArouterUrlManage.ARTICLE_PROJECT_FRAGMENT)
class ProjectFragment : BaseVMFragment() {
    private var mediator : TabLayoutMediator? = null
    override fun getLayoutRes(): Int = R.layout.article_layout_project_fragment

    private val mViewModel by lazy {
        initViewModel(
            this, ProjectFmViewModel::class, ProjectFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun initView() {
        mViewModel.projectTreeBean.observe(this, Observer {
            val titles = arrayListOf<String>()
            val fragments = arrayListOf<BaseVMFragment>()
            titles.add("最新")
            fragments.add(ProjectListFragment.newInstance(0))
            for (category in it) {
                titles.add(Html.fromHtml(category.name).toString())
                fragments.add(ProjectListFragment.newInstance(category.id))
            }

            val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle,fragments)

            vp_project.offscreenPageLimit = it.size + 1
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