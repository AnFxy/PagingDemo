package com.yucfangxiaoyun.pagingdemo.provide.datasource

import android.app.Application
import androidx.room.Room
import com.yucfangxiaoyun.pagingdemo.common.extensions.Constants
import com.yucfangxiaoyun.pagingdemo.core.datasource.local.AppDataBaseConfig
import com.yucfangxiaoyun.pagingdemo.core.datasource.local.daos.ArticlesDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DaoProvides @Inject constructor(
    private val application: Application
) {
    private val db = Room.databaseBuilder(
        application,
        AppDataBaseConfig::class.java,
        Constants.DATABASE_NAME
    ).build()

    fun provideArticleDao(): ArticlesDao = db.articlesDao()
}
