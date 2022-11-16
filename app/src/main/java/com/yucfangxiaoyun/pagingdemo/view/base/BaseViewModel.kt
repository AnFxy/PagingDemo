package com.yucfangxiaoyun.pagingdemo.view.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    // we send toast event to ui
    private val toastEvent = MutableSharedFlow<String>()
    val _toastEvent: SharedFlow<String> = toastEvent

    fun sendToast(toastText: String) {
        viewModelScope.launch {
            toastEvent.emit(toastText)
        }
    }
}