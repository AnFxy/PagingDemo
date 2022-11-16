package com.yucfangxiaoyun.pagingdemo.core.datasource.local.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleTable(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "article_pages") val pages: Int,
    @ColumnInfo(name = "article_title") val title: String,
    @ColumnInfo(name = "article_content") val content: String,
)
