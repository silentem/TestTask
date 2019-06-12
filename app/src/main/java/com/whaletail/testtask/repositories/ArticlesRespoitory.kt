package com.whaletail.testtask.repositories

import com.whaletail.testtask.data.Article
import io.reactivex.Completable

class ArticlesRepository(val articlesDao: ArticlesDao) {

    fun getArticles() = articlesDao.getArticles()

    fun updateArticles(articles: List<Article>) = articlesDao.updateArticles(articles)

}