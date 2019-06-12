package com.whaletail.testtask.repositories

import com.whaletail.testtask.data.Article

class ArticlesRepository(private val articlesDao: ArticlesDao) {

    fun getArticles() = articlesDao.getArticles()

    fun updateArticles(articles: List<Article>) = articlesDao.updateArticles(articles)

}