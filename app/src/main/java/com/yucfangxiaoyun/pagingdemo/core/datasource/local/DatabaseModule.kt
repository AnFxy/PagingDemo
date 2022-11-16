package com.yucfangxiaoyun.pagingdemo.core.datasource.local

import com.yucfangxiaoyun.pagingdemo.core.datasource.local.daos.ArticlesDao
import com.yucfangxiaoyun.pagingdemo.provide.datasource.DaoProvides
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

/**
 * 对于接口，我们没办法通过构造函数实例化的方式将其注入到其他类中。
 * 所以我们需要一个module去声明接口的实现类是哪个?
 * 对于可提供实现类的接口，我们通常将一个抽象类添加module声明以及作用域，
 * 然后提供一个参数传入为接口返回为接口实现类的抽象方法。
 * 对于不可提供实现类的接口，比如第三库中的接口（Retrofit, Room）等，
 * 我们一般用一个添加module注解和作用域的单例类，然后通过公有方法，提供接口的实现。
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideArticleDao(daoProvides: DaoProvides): ArticlesDao =
        daoProvides.provideArticleDao()
}