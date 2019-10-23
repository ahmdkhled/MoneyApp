package com.moneybank.moneyapp.account.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.moneybank.moneyapp.R
import com.moneybank.moneyapp.account.model.ProductResponse
import com.moneybank.moneyapp.base.AbstractBaseActivity
import com.moneybank.moneyapp.base.absActivityBuilder
import com.moneybank.moneyapp.util.EXTRA_RESPONSE


/**
 * [AccountDetailActivity] :
 *
 *
 * @author Rucha Bhatt
 * @version 1.0.0
 * @since 23-10-2019
 */
class AccountDetailActivity : AbstractBaseActivity() {

    private val accountDetailActivityBinder by lazy {
        return@lazy AccountDetailActivityBinder()
    }

    private val accountViewModel by lazy {
        ViewModelProviders.of(this)[AccountViewModel::class.java]
    }

    override fun setUpBuilder() = absActivityBuilder {
        contentView = R.layout.activity_account_detail
        abstractBinding = accountDetailActivityBinder
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        supportActionBar?.title = getString(R.string.title_account_detail)
        accountDetailActivityBinder.product.set(intent?.getSerializableExtra(EXTRA_RESPONSE) as? ProductResponse)
        observePayment()
        setupPaymentClick()
    }

    private fun observePayment() {
        accountViewModel.paymentLiveData.observe(this, Observer {
            accountDetailActivityBinder.product.get().apply {
                this?.Moneybox = it?.Moneybox ?: 0.0
            }
            accountDetailActivityBinder.product.notifyChange()
        })
    }

    private fun setupPaymentClick() {
        accountDetailActivityBinder.binding?.btnAdd?.setOnClickListener {
            accountDetailActivityBinder.product.get()?.Id?.let { id ->
                accountViewModel.oneOffPayment(
                    10,
                    id
                )
            }
        }
    }
}