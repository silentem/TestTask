package com.whaletail.testtask.view.articleList

import dagger.Module
import dagger.Provides

@Module
class ArticleListFragmentModule {

    @Provides
    fun provideAdapter(fragment: ArticleListFragment) = ArticleListAdapter(fragment)

}