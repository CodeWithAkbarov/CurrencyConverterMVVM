package iqro.mobile.currencyconvertermvvm.data.models

data class ExchangeResponse(
    val info: Info,
    val query: Query,
    val result: Double,
    val success: Boolean
)