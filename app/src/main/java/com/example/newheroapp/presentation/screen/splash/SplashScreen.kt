package com.example.newheroapp.presentation.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newheroapp.R
import com.example.newheroapp.navigation.Screen
import com.example.newheroapp.ui.theme.Purple200
import com.example.newheroapp.ui.theme.Purple700

@Composable
fun SplashScreen(navController: NavController, splashViewModel: SplashViewModel = hiltViewModel()) {

    val onBoardingCompleted by splashViewModel.onBoardingScreen.collectAsState()
    val rotate = remember {
        Animatable(0f)

    }

    LaunchedEffect(key1 = true) {
        rotate.animateTo(targetValue = 360f, animationSpec = tween(3000, 500))

        navController.popBackStack()
        if (onBoardingCompleted){
            navController.navigate(Screen.Home.route)
        }else{
            navController.navigate(Screen.Welcome.route)
        }
    }

    Splash(rotate.value)
}

@Composable
fun Splash(rotate: Float) {
    if (isSystemInDarkTheme()) {

        Box(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(rotate),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(
                    id = R.string.app_name
                ),
            )
        }

    } else {
        Box(
            modifier = Modifier
                .background(Brush.horizontalGradient(colors = listOf(Purple700, Purple200)))
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(rotate),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(
                    id = R.string.app_name
                )
            )
        }
    }
}

