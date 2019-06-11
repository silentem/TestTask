package com.whaletail.testtask.dagger.moduels

import android.app.Application
import androidx.room.Room
import com.whaletail.testtask.BaseDatabase
import com.whaletail.testtask.BuildConfig
import com.whaletail.testtask.dagger.annotations.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * @author whaletail on 18.04.18.
 */

@Module
class RoomModule(application: Application) {

    var database: BaseDatabase = Room.databaseBuilder(
        application,
        BaseDatabase::class.java, BuildConfig.DB_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @ApplicationScope
    @Provides
    fun providesDatabase() = database
}