package com.example.newheroapp.navigation

sealed class Screen(val route:String){

    object Splash:Screen("splash_screen")
    object Welcome:Screen("welcome_screen")
    object Home:Screen("home")
    object Details:Screen("detail_screen/{heroId}"){
        fun passHeroId(heroId:Int):String{
            return "detail_screen${heroId }"
        }
    }
    object Search:Screen("search_screen")
}
