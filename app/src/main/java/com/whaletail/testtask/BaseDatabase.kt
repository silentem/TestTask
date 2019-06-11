package com.whaletail.testtask

import androidx.room.Database
import androidx.room.RoomDatabase
import com.whaletail.testtask.data.Article


@Database(
    entities = [
        Article::class
    ],
    version = 1
)
abstract class BaseDatabase : RoomDatabase() {
}