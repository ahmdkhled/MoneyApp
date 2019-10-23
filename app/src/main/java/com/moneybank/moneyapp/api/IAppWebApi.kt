package com.moneybank.moneyapp.api

import com.example.minimoneybox.login.model.LoginRequestDto
import com.example.minimoneybox.login.model.LoginResponseDto
import com.moneybank.moneyapp.account.model.AccountDetailDTO
import com.moneybank.moneyapp.account.model.ProductResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/**
 * [RetrofitSingleton] :
 *
 * @author Rucha Bhatt
 * @version 1.0.0
 * @since 23-10-2019
 */

interface IAppWebApi {

    @POST("users/login")
    fun login(@Body info: LoginRequestDto): Call<LoginResponseDto?>

    @GET("investorproducts")
    fun getAccountDetail(): Call<AccountDetailDTO?>

    @POST("oneoffpayments")
    fun offPayment(@Body paymentObject:HashMap<String, Any>): Call<ProductResponse?>
}