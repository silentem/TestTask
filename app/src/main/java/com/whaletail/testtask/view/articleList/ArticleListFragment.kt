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
import kotlinx.android.synthetic.main.fragment_article_list.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class ArticleListFragment : BaseFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val articleViewModel by lazy { getFragmentViewModel<ArticleListViewModel>(viewModelFactory) }

    @Inject
    lateinit var adapter: ArticleListAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        articleViewModel?.apply {
            observe(articlesLiveData) {
                when (it) {
                    is NewsResponseState.Success -> {
                        srlRoot.isRefreshing = false
                        adapter.articles = it.articles
                    }
                    is NewsResponseState.Error -> {
                        srlRoot.isRefreshing = false
                        context?.toast(it.message ?: getString(R.string.ops_error_occurred))
                    }
                }
            }
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvArticles.adapter = adapter
        srlRoot.setOnRefreshListener { updateArticles() }
        updateArticles()
    }

    private fun updateArticles() {
        srlRoot.isRefreshing = true
        articleViewModel?.getNews()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ArticleListFragment()
    }
}
