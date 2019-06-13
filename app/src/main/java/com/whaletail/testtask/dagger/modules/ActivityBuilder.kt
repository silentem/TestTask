package com.whaletail.testtask.dagger.modules

import com.whaletail.testtask.view.GeneralActivity
import com.whaletail.testtask.view.GeneralActivityModule
import com.whaletail.testtask.view.GeneralFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author whaletail on 20.03.18.
 */

@Module
abstract class ActivityBuilder {
     @ContributesAndroidInjector(modules = [GeneralActivityModule::class, GeneralFragmentProvider::class])
    abstract fun bindGeneralActivity(): GeneralActivity
}