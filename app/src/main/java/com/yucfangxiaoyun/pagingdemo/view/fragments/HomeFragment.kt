package com.yucfangxiaoyun.pagingdemo.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.yucfangxiaoyun.pagingdemo.R
import com.yucfangxiaoyun.pagingdemo.databinding.FragmentHomeBinding
import com.yucfangxiaoyun.pagingdemo.databinding.FragmentHomeDetailBinding
import com.yucfangxiaoyun.pagingdemo.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var navController: NavController

    override fun setLayout() {
        navController = findNavController()

        binding.btnGoHomeDetail.setOnClickListener {
            navController.navigate(
                HomeFragmentDirections.goHomeDetailFragmentFromHomeFragment()
            )
        }
    }

    override fun getViewBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, parent, false)

    override fun setObserver() {

    }
}
