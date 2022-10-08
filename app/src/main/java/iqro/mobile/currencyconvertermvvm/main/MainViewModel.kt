package iqro.mobile.currencyconvertermvvm.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import iqro.mobile.currencyconvertermvvm.utils.ConvertEvent
import iqro.mobile.currencyconvertermvvm.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *Created by Zohidjon Akbarov
 */

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _conversion = MutableStateFlow<ConvertEvent>(ConvertEvent.Empty)
    val conversion: StateFlow<ConvertEvent> get() = _conversion

    fun getConvertRate(
        from: String,
        to: String,
        amount: String
    ) {
        if (amount.isBlank()) {
            return
        }
        viewModelScope.launch {
            _conversion.value = ConvertEvent.Loading
            when (val result = mainRepository.convertRate(from, to, amount)) {
                is Resource.Error -> {
                    _conversion.value = ConvertEvent.Error(result.message)
                }
                is Resource.Success -> {
                    if (result.data != null) {
                        _conversion.value = ConvertEvent.Success(result.data)
                    } else {
                        _conversion.value = ConvertEvent.Error(null)
                    }
                }
            }
        }
    }
}