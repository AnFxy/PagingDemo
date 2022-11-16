package com.yucfangxiaoyun.pagingdemo.common.di

import com.yucfangxiaoyun.pagingdemo.core.usecase.ISaveArticlesView
import com.yucfangxiaoyun.pagingdemo.core.usecase.SaveArticlesToDatabaseUseCase
import com.yucfangxiaoyun.pagingdemo.provide.repository.ArticleRepository
import javax.inject.Inject

class UseCaseProvider @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    fun provideSaveArticlesToDataBaseUseCase(
        view: ISaveArticlesView
    ) = SaveArticlesToDatabaseUseCase(
        articleRepository,
        view
    )
}
