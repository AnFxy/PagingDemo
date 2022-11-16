package com.yucfangxiaoyun.pagingdemo.view.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.yucfangxiaoyun.pagingdemo.R
import com.yucfangxiaoyun.pagingdemo.databinding.ActivityMainBinding
import com.yucfangxiaoyun.pagingdemo.view.extensions.withBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by withBinding(ActivityMainBinding::inflate)

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as
                NavHostFragment
        navController = navHostFragment.navController

        binding.nvBottom.setupWithNavController(navController)
    }
}