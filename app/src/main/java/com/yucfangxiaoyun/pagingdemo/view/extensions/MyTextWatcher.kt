package com.yucfangxiaoyun.pagingdemo.view.extensions

import android.text.Editable
import android.text.TextWatcher

class MyTextWatcher(
    private val onTextChanged: (String?) -> Unit
) : TextWatcher {

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // Do nothing
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // Do nothing
    }

    override fun afterTextChanged(p0: Editable?) {
        val currentText = p0?.filters.contentToString()
        onTextChanged.invoke(currentText)
    }
}