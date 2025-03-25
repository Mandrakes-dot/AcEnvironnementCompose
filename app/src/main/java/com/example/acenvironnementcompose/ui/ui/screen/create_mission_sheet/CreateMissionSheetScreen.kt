package com.example.acenvironnementcompose.ui.ui.screen.create_mission_sheet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.logic.model.MissionSheetsModel
import com.example.acenvironnementcompose.logic.viewmodel.CreateMissionSheetViewModel
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.comon.AppButton
import com.example.acenvironnementcompose.ui.ui.comon.AppTopBar
import com.example.acenvironnementcompose.ui.ui.screen.navigation.Screen


@Composable
fun CreateMissionSheetScreen(
    navcontroller: NavHostController,
    viewmodel: CreateMissionSheetViewModel,
    param: Int
) {
    val context = LocalContext.current

    val client by viewmodel.client.collectAsState()

    viewmodel.getClient(param)

    CreateMissionsSheetContent(
        onClick = { diagForm->
            viewmodel.createMissionSheet(context,param,diagForm)
            viewmodel.updateClient(client!!)
            navcontroller.navigate(Screen.Main.route)
        }
    )
}


@Composable
fun CreateMissionsSheetContent(
    onClick:(MissionSheetsModel)-> Unit
) {

    var diagForm by remember { mutableStateOf(MissionSheetsModel()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.MainBackGround))
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        AppTopBar("Creer mission")

        OutlinedCard(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(top = 50.dp)
                .height(height = 340.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = false,
                    onClick = {

                    },
                    modifier = Modifier.padding(start = 30.dp)
                )
                Text(
                    "Maison"
                )
                RadioButton(
                    selected = false,
                    onClick = {
                    }
                )
                Text(
                    "Appartement"
                )
            }

            OutlinedTextField(
                value = diagForm.missionOrder,
                onValueChange =
                {diagForm = diagForm.copy(missionOrder = it)} ,
                label = {Text("Ordre de mission")},
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = diagForm.constructionYear.toString(),
                onValueChange =
                {
                    val newValue = it.toIntOrNull() ?: 0
                    diagForm = diagForm.copy(constructionYear = newValue)
                },
                label = { Text("Annee de construction") },
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = diagForm.housingType,
                onValueChange = {diagForm = diagForm.copy(housingType = it)},
                label = { Text("surface habitable") },
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = diagForm.stories,
                onValueChange = {diagForm = diagForm.copy(stories = it)},
                label = { Text("Etages") },
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )
        }

        OutlinedCard(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(top = 20.dp)
                .height(height = 310.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
        ) {

            OutlinedTextField(
                value = diagForm.fiscalNumber.toString(),
                onValueChange = {
                    val newValue = it.toLongOrNull() ?: 0L
                    diagForm = diagForm.copy(fiscalNumber = newValue)
                                },
                label = { Text("Numero Fiscal") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = diagForm.cadastralSection,
                onValueChange = {diagForm = diagForm.copy(stories = it)},
                label = { Text("Section Cadastal") },
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = diagForm.heatingType,
                onValueChange = {diagForm = diagForm.copy(heatingType = it)},
                label = { Text("Type de chauffage") },
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )
        }

        OutlinedCard(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(top = 20.dp)
                .height(height = 170.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
        ) {
            OutlinedTextField(
                value = diagForm.address,
                onValueChange = {diagForm = diagForm.copy(address = it)},
                label = { Text("Adresse") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = diagForm.postalCode,
                onValueChange = {diagForm = diagForm.copy(postalCode = it)},
                label = { Text("Code postal") },
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            )

        }

        OutlinedCard(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ){
                diagForm.diagnosticList.forEachIndexed { index, diagnostics ->

                    Row() {
                        Checkbox(
                            checked = diagnostics.isSelected,
                            onCheckedChange = { isSelected ->
                                diagForm = diagForm.copy(
                                    diagnosticList = diagForm.diagnosticList.toMutableList().apply {
                                        this[index] = diagnostics.copy(isSelected = isSelected)
                                    }
                                )
                            }
                        )

                        Text(
                            text = diagnostics.type.toString()
                        )
                    }
                }
            }
        }

        AppButton(
            text = "Save",
            onclick = {
                onClick(diagForm)
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 23.dp)
                .padding(top = 10.dp)
                .padding(bottom = 40.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddClientScreenPreview() {
    AcEnvironnementComposeTheme {
        CreateMissionsSheetContent({

        })
    }
}
