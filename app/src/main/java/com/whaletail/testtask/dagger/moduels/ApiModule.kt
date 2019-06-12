package com.whaletail.testtask.dagger.moduels

import com.whaletail.testtask.api.NewsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun providesNewsApi(retrofit: Retrofit) = retrofit.create(NewsApi::class.java)
}