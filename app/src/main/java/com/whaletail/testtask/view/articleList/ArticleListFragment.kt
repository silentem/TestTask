package com.whaletail.testtask.view.articleList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseFragment
import com.whaletail.testtask.observe
import com.whaletail.testtask.withViewModel
import kotlinx.android.synthetic.main.fragment_article_list.*
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import javax.inject.Inject

class ArticleListFragment : BaseFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ArticleListViewModel

    @Inject
    lateinit var adapter: ArticleListAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        withViewModel<ArticleListViewModel>(viewModelFactory) {
            viewModel = this
            observe(articlesLiveData) {
                when (it) {
                    is NewsResponseState.Success -> {
                        srlRoot.isRefreshing = false
                        adapter.articles = it.articles
                        info { it.articles }
                    }
                    is NewsResponseState.Error -> {
                        srlRoot.isRefreshing = false
                        context?.toast(it.message ?: getString(R.string.ops_error_occurred))
                    }
                }
            }
            viewModel.getNews()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvArticles.adapter = adapter
        srlRoot.setOnRefreshListener { viewModel.getNews() }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ArticleListFragment()
    }
}
