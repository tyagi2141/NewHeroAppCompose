package com.example.newheroapp.domain.use_cases.save_onBoarding

import com.example.newheroapp.data.repository.Repository

class SaveOnBoardingUseCase(private val repository: Repository) {

    suspend operator fun invoke(completed:Boolean){
        repository.onBoardingSaveState(completed = completed)
    }


}