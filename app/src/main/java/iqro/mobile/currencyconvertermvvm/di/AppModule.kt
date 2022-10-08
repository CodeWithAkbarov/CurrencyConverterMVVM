package iqro.mobile.currencyconvertermvvm.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import iqro.mobile.currencyconvertermvvm.data.ConverterApi
import iqro.mobile.currencyconvertermvvm.main.MainRepository
import iqro.mobile.currencyconvertermvvm.main.MainRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *Created by Zohidjon Akbarov
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getConverterApi(): ConverterApi {
        return Retrofit
            .Builder()
            .baseUrl("https://api.apilayer.com/currency_data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConverterApi::class.java)

    }

    @Singleton
    @Provides
    fun getMainRepository(api: ConverterApi): MainRepository = MainRepositoryImpl(api)

}