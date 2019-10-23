package com.moneybank.moneyapp.account.view

import androidx.databinding.ObservableField
import com.moneybank.moneyapp.account.model.ProductResponse
import com.moneybank.moneyapp.base.AbstractBinding
import com.moneybank.moneyapp.databinding.ActivityAccountDetailBinding

/**
 * [AccountDetailActivityBinder] :
 *
 *
 * @author Rucha Bhatt
 * @version 1.0.0
 * @since 23-10-2019
 */
class AccountDetailActivityBinder : AbstractBinding<ActivityAccountDetailBinding>() {
    val product = ObservableField<ProductResponse>()

    override fun onCreated() {
        binding?.accountDetailActivityBinder = this
    }

    override fun onDestroy() {
        binding?.accountDetailActivityBinder = null
    }
}