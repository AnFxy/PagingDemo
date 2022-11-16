package com.yucfangxiaoyun.pagingdemo.core.repository

import com.yucfangxiaoyun.pagingdemo.core.datasource.local.tables.ArticleTable

interface IArticleRepository {

    suspend fun saveArticlesToLocal(articleTable: ArticleTable)
}
