package com.whaletail.testtask.view

import android.os.Bundle
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseActivity
import com.whaletail.testtask.view.articleList.ArticleListFragment
import org.jetbrains.anko.toast

class GeneralActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)

        if (savedInstanceState == null) {
            navigateToList()
        }
    }

    private fun navigateToList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootFragmentHolder, ArticleListFragment.newInstance())
            .commit()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }
    }

}
