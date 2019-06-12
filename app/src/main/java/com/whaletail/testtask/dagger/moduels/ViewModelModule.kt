package com.whaletail.testtask.dagger.moduels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.whaletail.testtask.base.ViewModelFactory
import com.whaletail.testtask.dagger.annotations.ApplicationScope
import com.whaletail.testtask.dagger.annotations.ViewModelKey
import com.whaletail.testtask.view.articleList.ArticleListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ApplicationScope
    @ViewModelKey(ArticleListViewModel::class)
    abstract fun bindArticleListViewModel(viewModel: ArticleListViewModel): ViewModel

    @Binds
    @ApplicationScope
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}