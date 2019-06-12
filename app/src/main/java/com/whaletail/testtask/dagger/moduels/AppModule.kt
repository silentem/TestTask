package com.whaletail.testtask.dagger.moduels

import android.app.Application
import android.content.Context
import com.whaletail.testtask.dagger.annotations.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @ApplicationScope
    fun provideContext(application: Application): Context {
        return application
    }

}