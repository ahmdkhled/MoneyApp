package com.example.minimoneybox.account.view

import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import com.moneybank.moneyapp.BR
import com.moneybank.moneyapp.R
import com.moneybank.moneyapp.account.model.AccountDetailDTO
import com.moneybank.moneyapp.account.model.ProductResponse
import com.moneybank.moneyapp.adapters.BindingRecyclerAdapter
import com.moneybank.moneyapp.base.AbstractBinding
import com.moneybank.moneyapp.databinding.ActivityUserAccountBinding


/**
 * [UserAccountActivityBinder] :
 *
 *
 * @author Rucha Bhatt
 * @version 1.0.0
 * @since 23-10-2019
 */
class UserAccountActivityBinder : AbstractBinding<ActivityUserAccountBinding>() {
    val userName = ObservableField<String?>()
    val accountDetail = ObservableField<AccountDetailDTO?>()
    var plansAdapter: BindingRecyclerAdapter? = null
        private set
    var onItemClickListener: ((ProductResponse?) -> Unit)? = null

    override fun onCreated() {
        binding?.userAccountBinder = this
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        plansAdapter = BindingRecyclerAdapter.Builder()
            .setLayoutResId(R.layout.item_list_plan)
            .onCreateHolderCallback { holder, adapter ->
                holder.binding.root.setOnClickListener {
                    onItemClickListener?.invoke(adapter.list[holder.adapterPosition] as? ProductResponse)
                }
            }
            .onBindViewHolderCallback { holder, pos, adapter ->
                holder.binding.setVariable(
                    BR.productAccountDTO,
                    adapter.list[pos]
                )
            }
            .build()
        binding?.rvPlans?.adapter = plansAdapter
        binding?.rvPlans?.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroy() {
        binding?.userAccountBinder = null
    }
}