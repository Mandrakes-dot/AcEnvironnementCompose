package com.example.acenvironnementcompose.ui.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.acenvironnementcompose.logic.viewmodel.AddClientViewModel
import com.example.acenvironnementcompose.logic.viewmodel.ConsultClientViewModel
import com.example.acenvironnementcompose.logic.viewmodel.CreateMissionSheetViewModel
import com.example.acenvironnementcompose.logic.viewmodel.LoginViewModel
import com.example.acenvironnementcompose.logic.viewmodel.MainViewModel
import com.example.acenvironnementcompose.logic.viewmodel.RegisterViewModel
import com.example.acenvironnementcompose.logic.viewmodel.SplashViewModel
import com.example.acenvironnementcompose.ui.ui.screen.MissionSheetPdf.PdfScreen
import com.example.acenvironnementcompose.ui.ui.screen.add_client.AddClientScreen
import com.example.acenvironnementcompose.ui.ui.screen.consult_client.ConsultClientScreen
import com.example.acenvironnementcompose.ui.ui.screen.create_mission_sheet.CreateMissionSheetScreen
import com.example.acenvironnementcompose.ui.ui.screen.login.LoginScreen
import com.example.acenvironnementcompose.ui.ui.screen.main.MainScreen
import com.example.acenvironnementcompose.ui.ui.screen.register.RegisterScreen
import com.example.acenvironnementcompose.ui.ui.screen.splash.SplashScreen


sealed class Screen(val route: String){
    object Splash : Screen("splash")
    object Main : Screen("main")
    object AddClient : Screen("add_client")
    object Login : Screen("login")
    object Register : Screen("register")
    object ClientList : Screen("client_list")
    object ConsultClient : Screen("consult_client/{my_param}")
    object CreateMissionSheet : Screen("create_mission_sheet/{my_param2}")
    object Pdf : Screen("pdf/{my_param3}")

}

@Composable
fun Nav(padding: Modifier) {

    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = Screen.Splash.route
    ){

        composable(Screen.Splash.route){
            val splashViewModel : SplashViewModel = hiltViewModel()
            SplashScreen(
                navController = navController,
                viewModel = splashViewModel
            )
        }

        composable(Screen.Login.route){
            val loginViewModel : LoginViewModel = hiltViewModel()
            LoginScreen(
                navController = navController,
                viewModel = loginViewModel
            )
        }

        composable(Screen.Register.route){
            val registerViewModel : RegisterViewModel = hiltViewModel()
            RegisterScreen(
                navController = navController,
                viewModel = registerViewModel
            )
        }

        composable(Screen.Main.route){
            val mainViewModel : MainViewModel = hiltViewModel()
            MainScreen(
                navController = navController,
                viewmodel = mainViewModel
            )
        }

        composable(Screen.AddClient.route){
            val addClientViewModel : AddClientViewModel = hiltViewModel()
            AddClientScreen(
                navcontroller = navController,
                viewmodel = addClientViewModel
            )
        }

        composable(
            route = Screen.ConsultClient.route,
            arguments = listOf(
                navArgument("my_param") {
                    type = NavType.IntType
                }
            )
            ){
            val param = it.arguments?.getInt("my_param") ?: 0
            val consultClientViewModel : ConsultClientViewModel = hiltViewModel()
            ConsultClientScreen(
                param = param,
                navcontroller = navController,
                viewmodel = consultClientViewModel,
            )
        }

        composable(
            route = Screen.CreateMissionSheet.route,
            arguments = listOf(
                navArgument("my_param2") {
                    type = NavType.IntType
                }
            )
        ){
            val createMissionSheetViewModel : CreateMissionSheetViewModel = hiltViewModel()
            val param = it.arguments?.getInt("my_param2") ?: 0
            CreateMissionSheetScreen(
                navcontroller = navController,
                viewmodel = createMissionSheetViewModel,
                param = param
            )
        }

        composable(
            route = Screen.Pdf.route,
            arguments = listOf(
                navArgument("my_param3") {
                    type = NavType.IntType
                }
            )
        ){
            val param = it.arguments?.getInt("my_param3") ?: 0
            PdfScreen(
                param = param
            )
        }
    }
}
