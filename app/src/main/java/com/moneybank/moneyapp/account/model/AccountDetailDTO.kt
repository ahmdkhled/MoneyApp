package com.moneybank.moneyapp.account.model

import java.io.Serializable

data class AccountDetailDTO(
    val MoneyboxEndOfTaxYear: String,
    val ProductResponses: List<ProductResponse>,
    val TotalContributionsNet: Int,
    val TotalEarnings: Double,
    val TotalEarningsAsPercentage: Double,
    val TotalPlanValue: Double
) : Serializable