package com.moneybank.moneyapp.account.model

import java.io.Serializable

data class Personalisation(
    val HideAccounts: HideAccounts,
    val QuickAddDeposit: QuickAddDeposit
) : Serializable