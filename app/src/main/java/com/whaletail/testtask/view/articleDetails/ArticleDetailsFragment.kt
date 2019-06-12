package com.whaletail.testtask.view.articleDetails


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseFragment
import com.whaletail.testtask.data.Article
import kotlinx.android.synthetic.main.fragment_article_details.*

private const val ARTICLE = "article"

class ArticleDetailsFragment : BaseFragment() {
    private val article: Article?
        get() = arguments?.getParcelable(ARTICLE)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvTitle.text = article?.title
        tvContent.text = article?.content
        Picasso.get()
            .load(article?.imgUrl)
            .into(ivImage)
    }

    companion object {
        @JvmStatic
        fun newInstance(article: Article) =
            ArticleDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARTICLE, article)
                }
            }
    }
}
