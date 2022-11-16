package com.yucfangxiaoyun.pagingdemo.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yucfangxiaoyun.pagingdemo.R
import com.yucfangxiaoyun.pagingdemo.databinding.FragmentLocalBinding
import com.yucfangxiaoyun.pagingdemo.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalFragment : BaseFragment<FragmentLocalBinding>() {

    override fun setLayout() {

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentLocalBinding =
        FragmentLocalBinding.inflate(inflater, parent, false)

    override fun setObserver() {

    }
}