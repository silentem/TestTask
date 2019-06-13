package com.whaletail.testtask.dagger.modules

import com.whaletail.testtask.api.NewsApi
import com.whaletail.testtask.dagger.annotations.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @ApplicationScope
    fun providesNewsApi(retrofit: Retrofit) = retrofit.create(NewsApi::class.java)
}