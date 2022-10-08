package iqro.mobile.currencyconvertermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import iqro.mobile.currencyconvertermvvm.main.MainViewModel
import iqro.mobile.currencyconvertermvvm.utils.ConvertEvent
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "TAG"
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getConvertRate("USD", "UZS", "20")
        lifecycleScope.launchWhenCreated {
            viewModel.conversion.collectLatest {
                when (it) {
                    ConvertEvent.Empty -> Unit
                    is ConvertEvent.Error -> Log.d(TAG, "onCreate: ${it.errorMessage}")
                    ConvertEvent.Loading -> Unit
                    is ConvertEvent.Success -> Log.d(TAG, "onCreate: ${it.result}")
                }
            }
        }
    }
}