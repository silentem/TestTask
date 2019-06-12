package com.whaletail.testtask.view.articleList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseFragment
import com.whaletail.testtask.withViewModel
import kotlinx.android.synthetic.main.fragment_article_list.*
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
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvArticles.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = ArticleListFragment()
    }
}
