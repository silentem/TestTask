package com.whaletail.testtask.view.articleList

import androidx.lifecycle.MutableLiveData
import com.whaletail.testtask.api.NewsApi
import com.whaletail.testtask.base.BaseViewModel
import com.whaletail.testtask.data.Article
import com.whaletail.testtask.printError
import com.whaletail.testtask.repositories.ArticlesRepository
import com.whaletail.testtask.runOnIo
import javax.inject.Inject


sealed class NewsResponseState {
    data class SuccessApi(val articles: List<Article>) : NewsResponseState()
    data class SuccessDb(val articles: List<Article>) : NewsResponseState()
    data class Error(val message: String? = null) : NewsResponseState()
}

class ArticleListViewModel @Inject constructor(
    private val newsApi: NewsApi,
    private val articlesRepository: ArticlesRepository
) : BaseViewModel() {

    val articlesLiveData: MutableLiveData<NewsResponseState> = MutableLiveData()

    fun getNews() {

        articlesRepository.getArticles()
            .flatMap {
                articlesLiveData.postValue(NewsResponseState.SuccessDb(it))
                newsApi.news()
            }
            .doOnSuccess { articlesRepository.updateArticles(it?.body ?: emptyList()) }
            .runOnIo()
            .printError { articlesLiveData.postValue(NewsResponseState.Error(it.localizedMessage)) }
            .subscribe { articles ->
                if (articles.errorMessage == null) {
                    articlesLiveData.postValue(NewsResponseState.SuccessApi(articles?.body ?: emptyList()))
                } else {
                    articlesLiveData.postValue(NewsResponseState.Error(articles.errorMessage))
                }
            }
            .disposeOnClear()

    }


}