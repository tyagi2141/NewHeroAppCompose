package com.example.newheroapp.presentation.screen.welcome

import android.graphics.drawable.PaintDrawable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.newheroapp.R
import com.example.newheroapp.navigation.Screen
import com.example.newheroapp.ui.theme.activeColor
import com.example.newheroapp.ui.theme.inActiveColor
import com.example.newheroapp.ui.theme.welcomeScreenBackground
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {

    val pages = listOf(OnBoardingScreen.First, OnBoardingScreen.Second, OnBoardingScreen.Third)
    val pageState = rememberPagerState();

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.welcomeScreenBackground)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pageState,
            verticalAlignment = Alignment.Top
        ) { page ->
            PageScreen(onBoardingScreen = pages[page])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pageState,
            activeColor = MaterialTheme.colors.activeColor,
            inactiveColor = MaterialTheme.colors.inActiveColor,
            indicatorWidth = 12.dp,
            spacing = 8.dp
        )
        FinishButton(modifier = Modifier.weight(1f), pagerState = pageState) {
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
            welcomeViewModel.saveOnBoardingState(completed = true)
        }
    }


}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(modifier: Modifier, pagerState: PagerState, onClick: () -> Unit) {
    Row(

        modifier = modifier.padding(10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,

        ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(onClick = onClick) {
                Text(text = "finish")

            }
        }
    }
}

@Composable
fun PageScreen(onBoardingScreen: OnBoardingScreen) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingScreen.image),
            contentDescription = "details images"
        )
        Text(

            text = onBoardingScreen.title,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp)
                .padding(),
            text = onBoardingScreen.description,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
    }
}