package com.yucfangxiaoyun.pagingdemo.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yucfangxiaoyun.pagingdemo.databinding.FragmentNetWorkBinding
import com.yucfangxiaoyun.pagingdemo.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NetWorkFragment : BaseFragment<FragmentNetWorkBinding>() {

    override fun setLayout() {

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentNetWorkBinding =
        FragmentNetWorkBinding.inflate(inflater, parent, false)

    override fun setObserver() {

    }
}
