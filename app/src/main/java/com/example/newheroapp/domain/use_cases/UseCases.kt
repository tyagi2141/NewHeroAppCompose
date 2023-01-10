package com.example.newheroapp.domain.use_cases

import com.example.newheroapp.domain.use_cases.read_onBoarding.ReadOnBoardingUseCase
import com.example.newheroapp.domain.use_cases.save_onBoarding.SaveOnBoardingUseCase

class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
) {
}