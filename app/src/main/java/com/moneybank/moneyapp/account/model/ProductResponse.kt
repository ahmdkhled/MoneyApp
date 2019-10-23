package com.moneybank.moneyapp.account.model

import java.io.Serializable

data class ProductResponse(
    val CollectionDayMessage: String,
    val ContributionStatus: String,
    val Id: Int,
    val InvestorAccount: InvestorAccount,
    val IsFavourite: Boolean,
    val IsSelected: Boolean,
    var Moneybox: Double,
    val Personalisation: Personalisation,
    val PlanValue: Double,
    val Product: Product,
    val SubscriptionAmount: Int,
    val TotalFees: Double
) : Serializable