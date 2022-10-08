package iqro.mobile.currencyconvertermvvm.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import iqro.mobile.currencyconvertermvvm.data.ConverterApi
import iqro.mobile.currencyconvertermvvm.main.MainRepository
import iqro.mobile.currencyconvertermvvm.main.MainRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 *Created by Zohidjon Akbarov
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getConverterApi(@ApplicationContext context: Context): ConverterApi {
        return Retrofit
            .Builder()
            .client(OkHttpClient.Builder().addInterceptor(ChuckerInterceptor(context)).build())
            .baseUrl("https://api.apilayer.com/currency_data/")
            .build()
            .create(ConverterApi::class.java)

    }

    @Singleton
    @Provides
    fun getMainRepository(api: ConverterApi): MainRepository = MainRepositoryImpl(api)

}