package com.aj.article_module.ui.system.system_classify_fragment

import android.os.Bundle
import android.text.Html
import android.view.View
import com.aj.article_module.R
import com.aj.article_module.adapter.ViewPagerAdapter
import com.aj.article_module.bean.PageDataInfo
import com.aj.article_module.bean.SystemTreeBean
import com.aj.article_module.ui.project.projectlist_fragment.SystemListFragment
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
@Route(path = ArouterUrlManage.ARTICLE_SYSTEM_CLASSIFY_FRAGMENT)
class SystemClassifyFragment : BaseVMFragment() {
    private var mediator : TabLayoutMediator? = null
    override fun getLayoutRes(): Int = R.layout.article_layout_project_fragment
    var  systemTreeBean : SystemTreeBean? = null
    companion object {
        fun newInstance(systemTreeBean : SystemTreeBean) =
            SystemClassifyFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PageDataInfo.systemTreeBean, systemTreeBean)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle  = arguments
        systemTreeBean = bundle?.getParcelable(PageDataInfo.systemTreeBean)!!
        super.onViewCreated(view, savedInstanceState)
    }

    private val mViewModel by lazy {
        initViewModel(
            this, SystemClassifyFmViewModel::class, SystemClassifyFmRepository::class
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun initView() {
        val titles = arrayListOf<String>()
        val fragments = arrayListOf<BaseVMFragment>()

        for (systemTreeChildrenItem in systemTreeBean?.children!!) {
            titles.add(Html.fromHtml(systemTreeChildrenItem.name).toString())
            fragments.add(SystemListFragment.newInstance(systemTreeChildrenItem.id))
        }

        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle,fragments)

        vp_project.offscreenPageLimit = 3
        vp_project.adapter = viewPagerAdapter
        projectTabLayout.tabMode = TabLayout.MODE_SCROLLABLE

        mediator = TabLayoutMediator(projectTabLayout, vp_project,
            TabConfigurationStrategy { tab, position -> //这里可以自定义TabView
                tab.text = titles[position]
            })
        //要执行这一句才是真正将两者绑定起来
        mediator!!.attach()
    }

}