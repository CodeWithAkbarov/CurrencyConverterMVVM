package iqro.mobile.currencyconvertermvvm.data

import iqro.mobile.currencyconvertermvvm.data.models.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 *Created by Zohidjon Akbarov
 */
interface ConverterApi {

    @Headers("apikey: gbkUbduVCCvw8eizftIG08rko0hkeXdF")
    @GET("convert")
    suspend fun convertRate(
        @Query("from") from:String,
        @Query("to") to:String,
        @Query("amount") amount:String
    ):Response<ExchangeResponse>

}