package com.whaletail.testtask.view.articleList

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whaletail.testtask.base.BaseAdapter

class ArticleListAdapter(articleListFragment: ArticleListFragment) :
    BaseAdapter<ArticleListAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
    }

    override fun getItemCount(): Int {
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}