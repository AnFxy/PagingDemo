package com.yucfangxiaoyun.pagingdemo.view.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yucfangxiaoyun.pagingdemo.R
import com.yucfangxiaoyun.pagingdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}