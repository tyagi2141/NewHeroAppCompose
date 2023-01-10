package com.example.newheroapp.di

import android.content.Context
import com.example.newheroapp.data.repository.DataStoreOperationImpl
import com.example.newheroapp.data.repository.Repository
import com.example.newheroapp.domain.repository.DataStoreOperation
import com.example.newheroapp.domain.use_cases.UseCases
import com.example.newheroapp.domain.use_cases.read_onBoarding.ReadOnBoardingUseCase
import com.example.newheroapp.domain.use_cases.save_onBoarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun dataStoreProvider(@ApplicationContext context: Context): DataStoreOperation {
        return DataStoreOperationImpl(context = context)
    }

    @Provides
    @Singleton
    fun useCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository)
        )
    }
}


