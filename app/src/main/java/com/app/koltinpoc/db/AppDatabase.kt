package com.app.koltinpoc.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.koltinpoc.db.dao.ArticleDao
import com.app.koltinpoc.db.entity.ArticleEntity

@Database(
    version = 1,
    entities = [ArticleEntity::class],
)
@TypeConverters(Converter::class)
abstract class AppDatabase :RoomDatabase(){

    abstract fun articleDao(): ArticleDao
}