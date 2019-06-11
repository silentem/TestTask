package com.whaletail.testtask.view

import com.whaletail.testtask.view.articleDetails.ArticleDetailsFragment
import com.whaletail.testtask.view.articleDetails.ArticleDetailsFragmentModule
import com.whaletail.testtask.view.articleList.ArticleListFragment
import com.whaletail.testtask.view.articleList.ArticleListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GeneralFragmentProvider {

    @ContributesAndroidInjector(modules = [ArticleDetailsFragmentModule::class])
    abstract fun articleDetailsFragment(): ArticleDetailsFragment

    @ContributesAndroidInjector(modules = [ArticleListFragmentModule::class])
    abstract fun structureFragment(): ArticleListFragment
}