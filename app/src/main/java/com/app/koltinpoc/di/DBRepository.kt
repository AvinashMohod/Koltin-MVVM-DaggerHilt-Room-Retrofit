package com.app.koltinpoc.di

import androidx.lifecycle.LiveData
import com.app.koltinpoc.db.AppDatabase
import com.app.koltinpoc.db.entity.ArticleEntity
import com.app.koltinpoc.di.Transformer.convertArticleModelToArticleEntity
import com.app.koltinpoc.model.Article
import javax.inject.Inject

class DBRepository @Inject constructor(val appDatabase: AppDatabase) {

    suspend fun insertArticle(article: Article): Long {
        return appDatabase.articleDao()
            .insert(convertArticleModelToArticleEntity(article))
    }

    suspend fun delete(article: Article) {
        appDatabase.articleDao().delete(convertArticleModelToArticleEntity(article))
    }

    // NOTE - Since we are already using LIVE-DATA no need to use suspend function
    fun getAllArticles(): LiveData<List<ArticleEntity>> {
        return appDatabase.articleDao().getAllOfflineArticles()
    }


}