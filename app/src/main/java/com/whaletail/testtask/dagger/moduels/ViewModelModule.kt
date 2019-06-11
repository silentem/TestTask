package com.whaletail.testtask.dagger.moduels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.whaletail.testtask.base.ViewModelFactory
import com.whaletail.testtask.dagger.annotations.ViewModelKey
import com.whaletail.testtask.view.GeneralViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GeneralViewModel::class)
    abstract fun bindKnowledgeBaseViewModel(viewModel: GeneralViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}