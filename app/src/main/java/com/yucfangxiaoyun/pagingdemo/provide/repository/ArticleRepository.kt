package com.yucfangxiaoyun.pagingdemo.provide.repository

import com.yucfangxiaoyun.pagingdemo.core.datasource.local.tables.ArticleTable
import com.yucfangxiaoyun.pagingdemo.core.repository.IArticleRepository
import com.yucfangxiaoyun.pagingdemo.provide.datasource.DaoProvides
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val daoProvides: DaoProvides
) : IArticleRepository {

    override suspend fun saveArticlesToLocal(articleTable: ArticleTable) {
        val articleDao = daoProvides.provideArticleDao()
        articleDao.insertArticle(articleTable)
    }
}
