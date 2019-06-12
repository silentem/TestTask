package com.whaletail.testtask.repositories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.whaletail.testtask.data.Article
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM Article")
    abstract fun getArticles(): Single<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun updateArticles(articles: List<Article>)
}