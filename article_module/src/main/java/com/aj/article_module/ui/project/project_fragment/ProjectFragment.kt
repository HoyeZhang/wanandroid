package com.aj.article_module.ui.project.project_fragment

import android.text.Html
import androidx.lifecycle.Observer
import com.aj.article_module.R
import com.aj.article_module.adapter.ViewPagerAdapter
import com.aj.article_module.ui.project.projectlist_fragment.PeojectListFragment
import com.aj.base_module.ui.fragment.BaseVMFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterUrlManage
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.article_layout_project_fragment.*

/**
 * @author zhy
 * @time 2020/8/16.
 */
@Route(path = ArouterUrlManage.ARTICLE_PROJECT_FRAGMENT)
class ProjectFragment : BaseVMFragment() {
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
            fragments.add(PeojectListFragment.newInstance(0))
            for (category in it) {
                titles.add(Html.fromHtml(category.name).toString())
                fragments.add(PeojectListFragment.newInstance(category.id))
            }

            val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
            viewPagerAdapter.setFragmentsAndTitles(fragments, titles)
            vp_project.offscreenPageLimit = it.size + 1
            vp_project.adapter = viewPagerAdapter
            projectTabLayout.tabMode = TabLayout.MODE_SCROLLABLE
            projectTabLayout.setupWithViewPager(vp_project)
        })
    }

    override fun initData() {
        super.initData()
        mViewModel.getProjectTree()
    }

}