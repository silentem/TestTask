package com.whaletail.testtask.view.articleList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseFragment
import javax.inject.Inject

class ArticleListFragment : BaseFragment() {

    @Inject
    lateinit var adapter: ArticleListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        @JvmStatic
        fun newInstance() = ArticleListFragment()
    }
}
