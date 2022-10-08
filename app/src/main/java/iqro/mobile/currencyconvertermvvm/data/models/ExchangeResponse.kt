package iqro.mobile.currencyconvertermvvm.data.models


import com.google.gson.annotations.SerializedName

data class ExchangeResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("query")
    val query: Query,
    @SerializedName("result")
    val result: Double,
    @SerializedName("success")
    val success: Boolean
)