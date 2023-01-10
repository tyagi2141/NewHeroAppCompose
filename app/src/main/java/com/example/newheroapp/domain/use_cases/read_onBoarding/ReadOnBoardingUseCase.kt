package com.example.newheroapp.domain.use_cases.read_onBoarding

import com.example.newheroapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    operator fun invoke():Flow<Boolean>{
        return repository.onReadOnBoardingState()
    }
}