package com.example.acenvironnementcompose.ui.ui.screen.register

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.logic.room.User
import com.example.acenvironnementcompose.logic.viewmodel.RegisterViewModel
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.comon.AppButton
import com.example.acenvironnementcompose.ui.ui.screen.navigation.Screen
import kotlinx.coroutines.withContext


@Composable
fun RegisterScreen(navController: NavHostController, viewModel: RegisterViewModel) {

    val context = LocalContext.current

    RegisterContent(
        onClick = {login, password, confirmPassword ->

            val user = User(
                null,
                login,
                password,
                false
            )

            if (login.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
//                Toast.makeText(context,"Tous les champs doivent être remplis correctement",Toast.LENGTH_SHORT).show()
                print("Utilisateur inconnu")

            }

            if(password != confirmPassword ){
//                Toast.makeText(context,"Mot de passe different",Toast.LENGTH_SHORT).show()
                print("Utilisateur inconnu")
            }else{
                viewModel.registerUser(user)
                navController.navigate(Screen.Login.route)
            }
        }
    )
}


@Composable
fun RegisterContent(
    onClick:(String,String,String)-> Unit
){

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.MainBackGround))
            .padding(bottom = 70.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedCard(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(height = 400.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
        ) {
            Text(
                "Register",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                fontSize = 24.sp,
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold
                )
            )

            OutlinedTextField(
                value = login,
                onValueChange = {login = it},
                label = { Text("Login") },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
            )

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = { Text("Password") },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .padding(horizontal =30.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = { Text("Confirm password") },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            AppButton(
                text = "Register",
                onclick = {
                    onClick(login,password,confirmPassword)
                },
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .height(50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AcEnvironnementComposeTheme {
    }
}