package com.whaletail.testtask.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.whaletail.testtask.R
import com.whaletail.testtask.base.BaseActivity
import com.whaletail.testtask.data.Article
import com.whaletail.testtask.observe
import com.whaletail.testtask.view.articleDetails.ArticleDetailsFragment
import com.whaletail.testtask.view.articleList.ArticleListFragment
import com.whaletail.testtask.withViewModel
import org.jetbrains.anko.toast
import javax.inject.Inject

class GeneralActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)

        navigateToList()
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
