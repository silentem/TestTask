package com.whaletail.testtask.dagger

import android.app.Application
import com.whaletail.testtask.BaseApplication
import com.whaletail.testtask.dagger.annotations.ApplicationScope
import com.whaletail.testtask.dagger.moduels.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication


@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        (NetworkModule::class),
        ActivityBuilder::class,
        RoomModule::class,
        ViewModelModule::class,
        ApiModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun roomModule(roomModule: RoomModule): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)

    fun inject(app: BaseApplication)

}