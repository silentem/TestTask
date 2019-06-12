package com.whaletail.testtask.view

import androidx.lifecycle.MutableLiveData
import com.whaletail.testtask.base.BaseViewModel
import com.whaletail.testtask.data.Article
import javax.inject.Inject

sealed class NavigationState {
    data class ArticleDetails(val article: Article) : NavigationState()
}

class GeneralViewModel @Inject constructor() : BaseViewModel() {

    val navigation : MutableLiveData<NavigationState> = MutableLiveData()

    fun navigateTo(navigationState: NavigationState) {
        navigation.postValue(navigationState)
    }

}