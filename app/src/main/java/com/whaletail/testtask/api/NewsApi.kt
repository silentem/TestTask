package com.whaletail.testtask.api

import com.whaletail.testtask.base.BaseResponse
import com.whaletail.testtask.data.Article
import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {

    @GET("newsfeed")
    fun orders(): Single<BaseResponse<List<Article>>>

}