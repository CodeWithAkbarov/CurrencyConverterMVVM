package iqro.mobile.currencyconvertermvvm.main

import iqro.mobile.currencyconvertermvvm.data.models.ExchangeResponse
import iqro.mobile.currencyconvertermvvm.utils.Resource

/**
 *Created by Zohidjon Akbarov
 */
interface MainRepository {

    suspend fun convertRate(
        from:String,
        to:String,
        amount:String
    ):Resource<ExchangeResponse>

}