package com.whaletail.testtask.view.articleDetails


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseFragment

private const val ARTICLE_ID = "id"

class ArticleDetailsFragment : BaseFragment() {
    private val articleId: String?
        get() = arguments?.getString(ARTICLE_ID)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        @JvmStatic
        fun newInstance(id: Long) =
            ArticleDetailsFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARTICLE_ID, id)
                }
            }
    }
}
