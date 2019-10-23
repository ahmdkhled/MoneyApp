package com.moneybank.moneyapp.account.model

import java.io.Serializable

data class HideAccounts(
    val Enabled: Boolean,
    val IsHidden: Boolean,
    val Sequence: Int
) : Serializable