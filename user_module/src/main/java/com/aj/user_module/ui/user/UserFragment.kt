package com.aj.user_module.ui.user

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aj.base_module.ui.fragment.BaseDataBindVMFragment
import com.aj.base_module.ui.viewmodel.BaseViewModel
import com.aj.base_module.ui.viewmodel.initViewModel
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.aj.data_service.Service.SharedPreferencesService
import com.aj.data_service.Service.UserService
import com.aj.data_service.bean.DataUser
import com.aj.user_module.R
import com.aj.user_module.adapter.UserTabChooseAdapter
import com.aj.user_module.bean.UserTabChooseBean
import com.aj.user_module.databinding.UserFragmentUserBinding
import com.aj.user_module.ui.login.LoginRepository
import com.aj.user_module.ui.login.LoginViewModel
import com.alibaba.android.arouter.facade.annotation.Autowired

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.user_fragment_user.*

/**
 * @author zhy
 * @time 2020/6/14.
 */
@Route(path = ArouterUrlManage.USER_FRAGEMNT)
class UserFragment : BaseDataBindVMFragment<UserFragmentUserBinding>() {

    @Autowired(name = ArouterUrlManage.DATAMODULEUSERSERVICE)
    @JvmField
    var userService: UserService? = null

    @Autowired(name = ArouterUrlManage.DATAMODULESHAREPREFERENCESSERVICE)
    @JvmField
    var sharedPreferencesService: SharedPreferencesService? = null

    private var dataUser: DataUser? = null

    private val mViewModel by lazy {
        initViewModel(
            this, UserFmViewModel::class, UserFmRepository::class
        )
    }

    private val userTabChooseAdapter: UserTabChooseAdapter by lazy {
        UserTabChooseAdapter()
    }

    private val staggeredGridLayoutManager: StaggeredGridLayoutManager by lazy {
        StaggeredGridLayoutManager(
            3,
            StaggeredGridLayoutManager.VERTICAL
        )
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun getLayoutRes() = R.layout.user_fragment_user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun initView() {

        tv_goto_login.setOnClickListener {
            ArouterPageManger.navigation(mActivity, ArouterUrlManage.USER_LOGINACTIVITY)
        }

        tv_logout.setOnClickListener {
            userService!!.clearLoginUser()
            initData()
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_user_tab_choose.run {
            adapter = userTabChooseAdapter
            layoutManager = staggeredGridLayoutManager
        }
        val favoritesTabBean = UserTabChooseBean(0, R.mipmap.user_ic_favorites, "我的收藏")
        val aboutTabBean = UserTabChooseBean(1, R.mipmap.user_ic_about, "关于")
        val settingTabBean = UserTabChooseBean(2, R.mipmap.user_ic_setting, "设置")
        val tabList: List<UserTabChooseBean> =
            listOf(favoritesTabBean, aboutTabBean, settingTabBean)
        userTabChooseAdapter.setList(tabList)
        userTabChooseAdapter.setOnItemClickListener { adapter, view, position ->
            when(tabList[position].id){
                0 ->{

                }
                1 ->{
                    ArouterPageManger.navigation(mActivity, ArouterUrlManage.USER_ABOUTACTIVITY)
                }

                2 ->{

                }

            }
        }
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    override fun initData() {
        super.initData()
        if(sharedPreferencesService?.getIsLogin()!!){
            dataUser = userService?.queryLoginUser()!!

            dataUser?.let {
                tv_name_first.text = it.username?.substring(0, 1) ?: ""
                tv_username.text = it.username
                tv_goto_login.visibility = View.INVISIBLE
                tv_username.visibility = View.VISIBLE
                tv_logout.visibility = View.VISIBLE
            }
        }else{
            tv_name_first.text = ""
            tv_username.visibility = View.INVISIBLE
            tv_goto_login.visibility = View.VISIBLE
            tv_logout.visibility = View.INVISIBLE
        }

    }

}