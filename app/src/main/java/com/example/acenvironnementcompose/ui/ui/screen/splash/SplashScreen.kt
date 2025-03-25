package com.example.acenvironnementcompose.ui.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.logic.viewmodel.SplashViewModel
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.screen.navigation.Screen


@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel) {
    SplashContent()
    viewModel.navigate()
    LaunchedEffect(true) {
        viewModel.goToOtherScreenSF.collect {
            navController.navigate(Screen.Login.route){
                popUpTo(Screen.Splash.route){
                    inclusive = true
                }
            }
        }
    }
}

@Composable
fun SplashContent(){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.MainBackGround))
    ) {
        Image(
            painter = painterResource(R.drawable.main_logo),
            contentDescription = "",
            modifier = Modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AcEnvironnementComposeTheme {
    }
}