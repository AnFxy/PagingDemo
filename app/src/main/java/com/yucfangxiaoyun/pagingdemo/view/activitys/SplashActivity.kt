package com.yucfangxiaoyun.pagingdemo.view.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.yucfangxiaoyun.pagingdemo.databinding.ActivitySplashBinding
import com.yucfangxiaoyun.pagingdemo.view.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    companion object {
        const val SHOW_LOGO = "SHOW_LOG"
        const val GO_MAIN_ACTIVITY = "GO_MAIN_ACTIVITY"
    }

    private lateinit var binding: ActivitySplashBinding
    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenResumed {
            viewModel._event.collect {
                when (it) {
                    SHOW_LOGO -> {
                        binding.ivMulan.visibility = View.VISIBLE
                        binding.txtSplashContent.visibility = View.VISIBLE
                    }
                    GO_MAIN_ACTIVITY -> startActivity(
                        Intent(
                            this@SplashActivity,
                            MainActivity::class.java
                        )
                    )
                    else -> {
                        // Do Nothing
                    }
                }
            }
        }
    }
}