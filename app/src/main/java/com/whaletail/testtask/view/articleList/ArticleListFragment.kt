package com.whaletail.testtask.view.articleList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseFragment
import com.whaletail.testtask.getFragmentViewModel
import com.whaletail.testtask.observe
import com.whaletail.testtask.view.GeneralViewModel
import com.whaletail.testtask.withViewModel
import kotlinx.android.synthetic.main.fragment_article_list.*
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import javax.inject.Inject

class ArticleListFragment : BaseFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val articleViewModel by lazy { getFragmentViewModel<ArticleListViewModel>(viewModelFactory) }
    lateinit var generalViewModel: GeneralViewModel

    @Inject
    lateinit var adapter: ArticleListAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        withViewModel<GeneralViewModel>(viewModelFactory) {
            generalViewModel = this
        }

        articleViewModel?.apply {
            observe(articlesLiveData) {
                when (it) {
                    is NewsResponseState.SuccessApi -> {
                        srlRoot.isRefreshing = false
                        adapter.articles = it.articles
                        info { "Api ${it.articles.size}" }
                    }
                    is NewsResponseState.SuccessDb -> {
                        srlRoot.isRefreshing = false
                        adapter.articles = it.articles
                        info { "Db ${it.articles.size}" }
                    }
                    is NewsResponseState.Error -> {
                        srlRoot.isRefreshing = false
                        context?.toast(it.message ?: getString(R.string.ops_error_occurred))
                    }
                }
            }
            srlRoot.isRefreshing = true
            articleViewModel?.getNews()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvArticles.adapter = adapter
        srlRoot.setOnRefreshListener { articleViewModel?.getNews() }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ArticleListFragment()
    }
}
