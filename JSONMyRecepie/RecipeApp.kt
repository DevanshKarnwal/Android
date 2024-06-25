package com.example.composepractice.NewPractice.JSONMyRecepie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp( navController: NavHostController ){
        val recipeViewModel : MainViewModel = viewModel()
        val viewState by recipeViewModel.categoryState  // so i don't have to use recipeViewModel.categoryState again and again
        NavHost(navController = navController, startDestination = Screen.RecipeScreen.route ) {
                composable(route = Screen.RecipeScreen.route){
                        RecipeScreen(viewState = viewState, navigateToDetail = {
//                                navController.currentBackStack?.savedStateHandle?.set("cat", it)
                                navController.navigate(Screen.DetailScreen.route)
                        }) 
                }
        }
}