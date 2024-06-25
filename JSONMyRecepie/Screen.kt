package com.example.composepractice.NewPractice.JSONMyRecepie

sealed class Screen( val route : String ) {
    object RecipeScreen : Screen("recipeScreen")
    object DetailScreen : Screen("detailScreen")
}