package com.yucfangxiaoyun.pagingdemo.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yucfangxiaoyun.pagingdemo.view.activitys.SplashActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val event = MutableSharedFlow<String>()
    val _event: SharedFlow<String> = event

    init {
        initSplashPage()
    }

    private fun initSplashPage() {
        viewModelScope.launch {
            delay(800)
            // 显示出logo
            event.emit(SplashActivity.SHOW_LOGO)
            delay(1500)
            // 前往MainActivity
            event.emit(SplashActivity.GO_MAIN_ACTIVITY)
        }
    }
}
