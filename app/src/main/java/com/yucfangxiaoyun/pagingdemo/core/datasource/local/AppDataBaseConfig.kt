package com.yucfangxiaoyun.pagingdemo.core.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yucfangxiaoyun.pagingdemo.core.datasource.local.daos.ArticlesDao
import com.yucfangxiaoyun.pagingdemo.core.datasource.local.tables.ArticleTable
import javax.inject.Singleton

@Database(entities = [ArticleTable::class], version = 1, exportSchema=false)
abstract class AppDataBaseConfig : RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao
}