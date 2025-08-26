package com.example.flash.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FlashApp(modifier: Modifier = Modifier,flashViewModel: FlashViewModel=viewModel(),NavController: NavHostController= rememberNavController()) {

    NavHost(navController=NavController, startDestination= Routes.StartScreen){

        composable(Routes.StartScreen){
            StartScreen(modifier=modifier,flashViewModel=flashViewModel,onCategoryClicked={
                NavController.navigate(Routes.ItemScreen)
            })
        }

        composable(Routes.ItemScreen){
            ItemScreen(modifier=modifier,flashViewModel)
        }

        composable(Routes.CartScreen){
            CartScreen(modifier=modifier)
        }
    }
}