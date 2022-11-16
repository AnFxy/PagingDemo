package com.yucfangxiaoyun.pagingdemo.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yucfangxiaoyun.pagingdemo.databinding.FragmentHomeDetailBinding
import com.yucfangxiaoyun.pagingdemo.view.base.BaseFragment
import com.yucfangxiaoyun.pagingdemo.view.extensions.MyTextWatcher
import com.yucfangxiaoyun.pagingdemo.view.viewmodels.HomeDetailFragViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeDetailFragment : BaseFragment<FragmentHomeDetailBinding>() {

    private val viewModel: HomeDetailFragViewModel by viewModels()

    override fun setLayout() {
        binding.apply {
            editAddArticlePages.addTextChangedListener(MyTextWatcher {
                viewModel.updateEditTextState(
                    pages = try {
                        it?.toInt()
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                        null
                    }
                )
            })

            editAddArticleTitle.addTextChangedListener(MyTextWatcher {
                viewModel.updateEditTextState(title = it)
            })

            editAddArticleContent.addTextChangedListener(MyTextWatcher {
                viewModel.updateEditTextState(content = it)
            })

            btnAddArticles.setOnClickListener {
                viewModel.saveArticles()
            }

            btnSelectArticles.setOnClickListener {

            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentHomeDetailBinding =
        FragmentHomeDetailBinding.inflate(inflater, parent, false)

    override fun setObserver() {
        lifecycleScope.launchWhenResumed {
            viewModel._editTextListStates.collect {
                binding.editAddArticlePages
            }
        }
    }

}