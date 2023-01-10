package com.example.newheroapp.data.repository

import com.example.newheroapp.domain.repository.DataStoreOperation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(val dataStoreOperation: DataStoreOperation) {

    suspend fun onBoardingSaveState(completed : Boolean){
        return dataStoreOperation.saveOnBoardingState(completed = completed)
    }

    fun onReadOnBoardingState(): Flow<Boolean> {
        return dataStoreOperation.readOnBoardingState()
    }
}