package com.yucfangxiaoyun.pagingdemo.view.extensions

import android.app.Activity
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> Activity.withBinding(inflate: (LayoutInflater) -> T) = lazy {
        inflate.invoke(layoutInflater)
    }
