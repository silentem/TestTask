package com.whaletail.testtask.view.articleList

import androidx.lifecycle.MutableLiveData
import com.whaletail.testtask.api.NewsApi
import com.whaletail.testtask.base.BaseViewModel
import com.whaletail.testtask.data.Article
import com.whaletail.testtask.printError
import com.whaletail.testtask.runOnIo
import javax.inject.Inject


sealed class NewsResponseState {
    data class Success(val articles: List<Article>) : NewsResponseState()
    data class Error(val message: String? = null) : NewsResponseState()
}

class ArticleListViewModel @Inject constructor(
    private val newsApi: NewsApi
) : BaseViewModel() {

    val articlesLiveData: MutableLiveData<NewsResponseState> = MutableLiveData()

    fun getNews() {

        newsApi.news()
            .runOnIo()
            .printError { articlesLiveData.postValue(NewsResponseState.Error(it.localizedMessage)) }
            .subscribe { articles -> articlesLiveData.postValue(NewsResponseState.Success(articles?.body ?: emptyList())) }
            .disposeOnClear()

    }


}