package com.whaletail.testtask

import com.whaletail.testtask.dagger.DaggerAppComponent
import com.whaletail.testtask.dagger.moduels.NetworkModule
import com.whaletail.testtask.dagger.moduels.RoomModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .roomModule(RoomModule(this))
            .build()
        component.inject(this)
        return component
    }
}