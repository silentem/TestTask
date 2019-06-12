package com.whaletail.testtask.view

import android.os.Bundle
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseActivity
import com.whaletail.testtask.view.articleList.ArticleListFragment

class GeneralActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)

        supportFragmentManager.beginTransaction()
            .replace(R.id.rootFragmentHolder, ArticleListFragment.newInstance())
            .addToBackStack(ArticleListFragment::class.simpleName)
            .commit()

    }
}
