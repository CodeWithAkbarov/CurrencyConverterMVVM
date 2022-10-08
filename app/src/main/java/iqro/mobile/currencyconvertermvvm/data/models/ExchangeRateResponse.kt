package iqro.mobile.currencyconvertermvvm.data.models

data class ExchangeRateResponse(
    val date: String,
    val info: Info,
    val query: Query,
    val result: Double,
    val success: Boolean
)