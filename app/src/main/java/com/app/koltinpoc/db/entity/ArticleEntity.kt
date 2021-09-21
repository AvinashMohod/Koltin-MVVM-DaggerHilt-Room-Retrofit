package com.app.koltinpoc.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ARTICLE")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceEntity?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)