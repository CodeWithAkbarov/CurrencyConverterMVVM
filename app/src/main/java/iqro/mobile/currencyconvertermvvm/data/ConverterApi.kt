package iqro.mobile.currencyconvertermvvm.data

import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Created by Zohidjon Akbarov
 */
interface ConverterApi {

    @GET("convert?to={to}&from={from}&amount={amount}")
    suspend fun getConverterRate(
        @Query("to") to:String,
        @Query("from") from:String,
        @Query("amount") amount:String,
    )

}