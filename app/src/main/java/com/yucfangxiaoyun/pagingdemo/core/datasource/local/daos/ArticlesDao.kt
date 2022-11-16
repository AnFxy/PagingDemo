package com.yucfangxiaoyun.pagingdemo.core.datasource.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yucfangxiaoyun.pagingdemo.core.datasource.local.tables.ArticleTable

@Dao
interface ArticlesDao {

    // select all articles from articleTable
    @Query("SELECT * FROM ArticleTable")
    suspend fun getAllArticles(): List<ArticleTable>

    // add an article to articleTable
    @Insert
    suspend fun insertArticle(vararg articleTable: ArticleTable)
}
