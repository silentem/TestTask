package com.whaletail.testtask.dagger.modules

import android.app.Application
import android.content.Context
import com.whaletail.testtask.dagger.annotations.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @ApplicationScope
    fun provideContext(application: Application): Context {
        return application
    }

}