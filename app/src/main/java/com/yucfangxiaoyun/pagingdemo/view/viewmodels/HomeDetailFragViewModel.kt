package com.yucfangxiaoyun.pagingdemo.view.viewmodels

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.yucfangxiaoyun.pagingdemo.R
import com.yucfangxiaoyun.pagingdemo.common.di.UseCaseProvider
import com.yucfangxiaoyun.pagingdemo.core.datasource.local.tables.ArticleTable
import com.yucfangxiaoyun.pagingdemo.core.usecase.ISaveArticlesView
import com.yucfangxiaoyun.pagingdemo.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeDetailFragViewModel @Inject constructor(
    private val application: Application,
    private val useCaseProvider: UseCaseProvider
) : BaseViewModel(), ISaveArticlesView {

    private val articleStates = MutableStateFlow(
        ArticleTable(
            pages = 0,
            title = "",
            content = ""
        )
    )
    val _articleStates: StateFlow<ArticleTable> = articleStates

    private val editTextListStates = MutableStateFlow(
        Triple(false, false, false)
    )
    val _editTextListStates: StateFlow<Triple<Boolean, Boolean, Boolean>> = editTextListStates

    fun saveArticles() {
        val saveArticlesUseCase = useCaseProvider.provideSaveArticlesToDataBaseUseCase(this)

        viewModelScope.launch {
            saveArticlesUseCase.execute(_articleStates.value)
        }
    }

    fun updateEditTextState(pages: Int? = null, title: String? = null, content: String? = null) {
        val oldArticleValue = _articleStates.value

        val newArticle = oldArticleValue.copy(
            pages = pages ?: oldArticleValue.pages,
            title = title ?: oldArticleValue.title,
            content = content ?: oldArticleValue.content
        )
        articleStates.value = newArticle
    }

    override fun onArticlesSavedResult(
        isSuccessful: Boolean,
        errorTriple: Triple<Boolean, Boolean, Boolean>?
    ) {
        if (isSuccessful) {
            sendToast(application.getString(R.string.add_article_successful))
        } else {
            errorTriple?.let {
                editTextListStates.value = it
            } ?: sendToast(application.getString(R.string.add_article_failed))
        }
    }
}