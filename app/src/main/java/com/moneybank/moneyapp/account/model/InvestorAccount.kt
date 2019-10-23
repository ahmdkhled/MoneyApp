package com.moneybank.moneyapp.account.model

import java.io.Serializable

data class InvestorAccount(
    val ContributionsNet: Int,
    val EarningsAsPercentage: Double,
    val EarningsNet: Double
) : Serializable