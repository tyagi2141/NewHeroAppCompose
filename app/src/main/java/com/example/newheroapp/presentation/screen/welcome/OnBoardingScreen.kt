package com.example.newheroapp.presentation.screen.welcome

import androidx.annotation.DrawableRes
import com.example.newheroapp.R

sealed class OnBoardingScreen(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {

    object First :
        OnBoardingScreen(image = R.drawable.greetings, title = "one", description = "one desc")

    object Second :
        OnBoardingScreen(image = R.drawable.explore, title = "second", description = "second")

    object Third :
        OnBoardingScreen(image = R.drawable.power, title = "third", description = "third")

}
