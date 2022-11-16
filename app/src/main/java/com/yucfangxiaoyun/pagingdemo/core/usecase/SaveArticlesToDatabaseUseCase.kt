package com.yucfangxiaoyun.pagingdemo.core.usecase

import com.yucfangxiaoyun.pagingdemo.core.datasource.local.tables.ArticleTable
import com.yucfangxiaoyun.pagingdemo.core.repository.IArticleRepository

class SaveArticlesToDatabaseUseCase(
    private val localRepository: IArticleRepository,
    private val viewModel: ISaveArticlesView
) {

    suspend fun execute(articleTable: ArticleTable) {
        try {
            // check the current article is available
            val pagesAvailable = articleTable.pages > 0
            val titleAvailable = articleTable.title.isNotEmpty()
            val contentAvailable = articleTable.content.isNotEmpty()
            if (pagesAvailable && titleAvailable && contentAvailable) {
                localRepository.saveArticlesToLocal(articleTable)
                // add article successfully
                viewModel.onArticlesSavedResult(isSuccessful = true)
            } else {
                viewModel.onArticlesSavedResult(
                    isSuccessful = false,
                    errorTriple = Triple(
                        first = !pagesAvailable,
                        second = !titleAvailable,
                        third = !contentAvailable
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            viewModel.onArticlesSavedResult(false)
        }
    }
}

interface ISaveArticlesView {
    fun onArticlesSavedResult(
        isSuccessful: Boolean,
        errorTriple: Triple<Boolean, Boolean, Boolean>? = null
    )
}
