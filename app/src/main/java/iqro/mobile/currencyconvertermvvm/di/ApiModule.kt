package iqro.mobile.currencyconvertermvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import iqro.mobile.currencyconvertermvvm.data.ConverterApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *Created by Zohidjon Akbarov
 */

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun getConverterApi(): ConverterApi = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ConverterApi::class.java)

}