package com.example.acenvironnementcompose.ui.ui.screen.add_client

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.logic.room.Client
import com.example.acenvironnementcompose.logic.viewmodel.AddClientViewModel
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.comon.AppButton
import com.example.acenvironnementcompose.ui.ui.comon.AppTopBar
import com.example.acenvironnementcompose.ui.ui.screen.navigation.Screen


@Composable
fun AddClientScreen(navcontroller: NavHostController, viewmodel: AddClientViewModel) {

    AddClientContent(
        onClick = { newClient ->
            viewmodel.addClient(newClient)
            navcontroller.navigate(Screen.Main.route)
        }
    )
}

@Composable
fun AddClientContent(
    onClick:(Client)->Unit
){
    var sex by remember { mutableIntStateOf(0) }
    var firstName by remember {mutableStateOf("")}
    var lastName by remember {mutableStateOf("")}
    var address by remember {mutableStateOf("")}
    var postalCode by remember {mutableStateOf("")}
    var city by remember {mutableStateOf("")}
    var phoneNumber by remember {mutableStateOf("")}
    var email by remember {mutableStateOf("")}
    var statut by remember {mutableStateOf("")}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.MainBackGround))
    ) {
        AppTopBar("Ajout client")

        OutlinedCard(
            shape = RoundedCornerShape(20.dp),
            modifier =Modifier
                .padding(top = 50.dp)
                .height(height = 240.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
        ) {
            Spacer(Modifier.padding(10.dp))
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = sex == 1,
                    onClick = {
                        sex = 1
                    },
                    modifier = Modifier.padding(start = 40.dp)
                )
                Text(
                    "Mr."
                )
                RadioButton(
                    selected = sex == 2,
                    onClick = {
                        sex = 2
                    }
                )
                Text(
                    "Mme."
                )
            }

            OutlinedTextField(
                value = firstName,
                onValueChange = {firstName = it},
                label = { Text("Prenom") },
                modifier = Modifier
                    .padding(start = 40.dp)
                    .width(200.dp)
            )

            Spacer(Modifier.padding(10.dp))

            OutlinedTextField(
                    value = lastName,
                    onValueChange = {lastName = it},
                    label = { Text("Nom") },
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .width(200.dp)

            )
        }

        OutlinedCard(
            shape = RoundedCornerShape(20.dp),
            modifier =Modifier
                .padding(top = 20.dp)
                .height(height = 440.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
        ){

            OutlinedTextField(
                value = address,
                onValueChange = {address = it},
                label = { Text("Adresse") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 40.dp)
                    .width(270.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                OutlinedTextField(
                    label = { Text("Ville") },

                    value = city,
                    onValueChange = {city = it},
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .padding(start = 40.dp)
                        .width(120.dp),
                )

                OutlinedTextField(
                    value = postalCode,
                    onValueChange = {postalCode = it},
                    label = { Text("Code postal")},
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .padding(start = 20.dp)
                        .width(130.dp)
                )
            }
            //reggex
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = {phoneNumber = it},
                label = { Text("Numero de telephone")},
                modifier = Modifier
                    .padding(top = 25.dp)
                    .padding(start = 40.dp)
                    .width(270.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text("Email")},

                modifier = Modifier
                    .padding(top = 25.dp)
                    .padding(start = 40.dp)
                    .width(270.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
            ){
                Text(
                    text = "Statut :",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 40.dp)
                )
                OutlinedTextField(
                    value = statut,
                    onValueChange = {statut = it},
                    label = { Text("Statut")},

                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(175.dp)
                        .clickable {

                        }
                )
            }
        }

        AppButton(
            text = "Save",
            onclick = {
                onClick(
                    Client(null,firstName, lastName, address, city, postalCode, phoneNumber.toLong(), email, sex,false)
                )
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 23.dp)
                .padding(top = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddClientScreenPreview() {
    AcEnvironnementComposeTheme {
//        AddClientContent()
    }
}