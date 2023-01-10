package com.example.newheroapp.di

import android.content.Context
import androidx.room.Room
import com.example.newheroapp.domain.local.BorutoDataBase
import com.example.newheroapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,BorutoDataBase::class.java,Constant.HERO_DATABASE
    ).build()

}