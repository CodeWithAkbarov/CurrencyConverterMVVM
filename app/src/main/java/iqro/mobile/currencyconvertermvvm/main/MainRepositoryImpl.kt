package iqro.mobile.currencyconvertermvvm.main

import iqro.mobile.currencyconvertermvvm.data.ConverterApi
import iqro.mobile.currencyconvertermvvm.data.models.ExchangeResponse
import iqro.mobile.currencyconvertermvvm.utils.Resource
import javax.inject.Inject

/**
 *Created by Zohidjon Akbarov
 */
class MainRepositoryImpl @Inject constructor(
    private val api: ConverterApi
) : MainRepository {
    override suspend fun convertRate(
        from: String,
        to: String,
        amount: String
    ): Resource<ExchangeResponse> {
        return try {
            val response = api.convertRate(to, from, amount)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body())
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }
}