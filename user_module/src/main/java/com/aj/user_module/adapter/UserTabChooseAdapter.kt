package com.aj.user_module.adapter


import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.aj.data_service.ArouterPageManger
import com.aj.data_service.ArouterUrlManage
import com.aj.user_module.R
import com.aj.user_module.bean.UserTabChooseBean
import com.aj.user_module.databinding.UserTabChooseItemBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder



/**
 *
 * @Package:        com.aj.article_module.adapter
 * @ClassName:      OfficialAccountListAdapter
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/8/03 11:12
 */

class UserTabChooseAdapter : BaseQuickAdapter<UserTabChooseBean, BaseViewHolder> {


    constructor(layoutResId: Int = R.layout.user_tab_choose_item) : super(
        layoutResId
    )

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onItemViewHolderCreated(viewHolder, viewType)
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView)

    }

    override fun convert(holder: BaseViewHolder, item: UserTabChooseBean) {
        var userTabChooseItemBinding : UserTabChooseItemBinding? =
            DataBindingUtil.getBinding(holder.itemView)
        if (userTabChooseItemBinding != null) {
            userTabChooseItemBinding.userTabChooseBean = item
        }
    }

}

