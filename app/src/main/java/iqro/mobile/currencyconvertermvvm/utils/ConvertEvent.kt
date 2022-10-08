package iqro.mobile.currencyconvertermvvm.utils

import iqro.mobile.currencyconvertermvvm.data.models.ExchangeResponse

/**
 *Created by Zohidjon Akbarov
 */
sealed class ConvertEvent {
    data class Success(val result: ExchangeResponse) : ConvertEvent()
    data class Error(val errorMessage: String?) : ConvertEvent()
    object Loading : ConvertEvent()
    object Empty : ConvertEvent()
}
