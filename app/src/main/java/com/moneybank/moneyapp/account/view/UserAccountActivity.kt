package com.example.minimoneybox.account.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.moneybank.moneyapp.R
import com.moneybank.moneyapp.account.view.AccountDetailActivity
import com.moneybank.moneyapp.account.view.AccountViewModel
import com.moneybank.moneyapp.base.AbstractBaseActivity
import com.moneybank.moneyapp.base.absActivityBuilder
import com.moneybank.moneyapp.base.startNewActivity
import com.moneybank.moneyapp.util.EXTRA_RESPONSE


/**
 * [UserAccountActivity] :
 *
 *
 * @author Rucha Bhatt
 * @version 1.0.0
 * @since 23-10-2019
 */
class UserAccountActivity : AbstractBaseActivity() {

    private val userAccountActivityBinder by lazy {
        return@lazy UserAccountActivityBinder()
    }
    private val accountViewModel by lazy {
        ViewModelProviders.of(this)[AccountViewModel::class.java]
    }

    override fun setUpBuilder() = absActivityBuilder {
        contentView = R.layout.activity_user_account
        abstractBinding = userAccountActivityBinder
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        supportActionBar?.title = getString(R.string.title_user_account_info)
        loadUsername()
        observerAccountDetails()
        userAccountActivityBinder.onItemClickListener = {
            startNewActivity(AccountDetailActivity::class.java) {
                putExtra(EXTRA_RESPONSE, it)
            }
        }
    }

    private fun observerAccountDetails() {
        accountViewModel.accountLiveData.observe(this, Observer {
            userAccountActivityBinder.accountDetail.set(it)
            userAccountActivityBinder.plansAdapter?.addAllItems(it?.ProductResponses?.toMutableList())
        })
    }

    private fun loadAccountDetails() {
        accountViewModel.getAccountDetail()
    }

    private fun loadUsername() {
        intent?.extras?.let {
            if (!it.getString("name").isNullOrEmpty())
                userAccountActivityBinder.userName.set(it.getString("name"))
        }
    }

    override fun onResume() {
        super.onResume()
        loadAccountDetails()
    }
}