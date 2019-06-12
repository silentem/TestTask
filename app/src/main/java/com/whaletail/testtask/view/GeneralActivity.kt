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
import javax.inject.Inject

class GeneralActivity : BaseActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: GeneralViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)


        withViewModel<GeneralViewModel>(viewModelFactory) {
            viewModel = this
            observe(navigation) {
                when (it) {
                    is NavigationState.ArticleDetails -> {
                        navigateToDetails(it.article)
                    }
                }
            }
        }

        navigateToList()

    }

    private fun navigateToList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootFragmentHolder, ArticleListFragment.newInstance())
            .addToBackStack(ArticleListFragment::class.simpleName)
            .commit()
    }

    private fun navigateToDetails(article: Article) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootFragmentHolder, ArticleDetailsFragment.newInstance(article))
            .addToBackStack(ArticleDetailsFragment::class.simpleName)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        }
    }

}
