package com.whaletail.testtask.view.articleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseAdapter

class ArticleListAdapter(val articleListFragment: ArticleListFragment) :
    BaseAdapter<ArticleListAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_article_list_view_holder, parent, false))
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind()
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {

        }
    }
}