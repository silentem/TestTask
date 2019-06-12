package com.whaletail.testtask.view.articleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseAdapter
import com.whaletail.testtask.data.Article
import com.whaletail.testtask.view.articleDetails.ArticleDetailsFragment
import kotlinx.android.synthetic.main.fragment_article_list_view_holder.view.*

class ArticleListAdapter(val articleListFragment: ArticleListFragment) :
    BaseAdapter<ArticleListAdapter.ArticleViewHolder>() {

    var articles = listOf<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_article_list_view_holder,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            itemView.apply {
                tvTitle.text = article.title
                setOnClickListener {
                    navigateToDetails(article)
                }
            }
        }

        private fun navigateToDetails(article: Article) {
            val fragmentByTag = articleListFragment.fragmentManager?.findFragmentByTag("article_list")
            fragmentByTag?.let {
                articleListFragment.fragmentManager?.beginTransaction()
                    ?.hide(it)
                    ?.add(R.id.rootFragmentHolder, ArticleDetailsFragment.newInstance(article))
                    ?.addToBackStack("article_details")
                    ?.commit()
            } ?: articleListFragment.fragmentManager?.beginTransaction()
                ?.replace(R.id.rootFragmentHolder, ArticleDetailsFragment.newInstance(article))
                ?.addToBackStack("article_details")
                ?.commit()
        }
    }
}