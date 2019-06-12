package com.whaletail.testtask

import androidx.room.Database
import androidx.room.RoomDatabase
import com.whaletail.testtask.data.Article
import com.whaletail.testtask.repositories.ArticlesDao


@Database(
    entities = [
        Article::class
    ],
    version = 2
)
abstract class BaseDatabase : RoomDatabase() {

    abstract fun getArticlesDao(): ArticlesDao

}