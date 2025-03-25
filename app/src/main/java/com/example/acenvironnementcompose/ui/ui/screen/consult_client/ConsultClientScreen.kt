package com.example.acenvironnementcompose.ui.ui.screen.consult_client

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.logic.room.Client
import com.example.acenvironnementcompose.logic.viewmodel.ConsultClientViewModel
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.comon.AppButton
import com.example.acenvironnementcompose.ui.ui.comon.AppTopBar
import com.example.acenvironnementcompose.ui.ui.comon.InfoRow
import com.example.acenvironnementcompose.ui.ui.screen.navigation.Screen


@Composable
fun ConsultClientScreen(
    navcontroller: NavHostController,
    viewmodel: ConsultClientViewModel,
    param: Int
) {

    viewmodel.getClient(param)

    val client by viewmodel.client.collectAsState()

    if (client != null) {
        ConsultClientContent(
            client = client!!,
            onClickNavToCreateMission = {navcontroller.navigate("create_mission_sheet/$param")},
            onClickNavToPdf = {navcontroller.navigate("pdf/$param")}
            )
    } else {
        CircularProgressIndicator()
    }
}

@Composable
fun ConsultClientContent(
    client:Client,
    onClickNavToCreateMission:()->Unit,
    onClickNavToPdf:()->Unit
) {

    var gender = ""

    when(client.gender){
        1 -> gender += "Mr"
        2 -> gender += "Mme"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.MainBackGround))
            .padding(16.dp)
    ) {
        AppTopBar("Consulter client")

        Spacer(modifier = Modifier.height(20.dp))

        ClientInfoCard(
            name = "$gender ${client.firstName} ${client.lastName}",
            address = client.address,
            city = client.ville,
            postalCode = client.postalCode,
            phoneNumber = client.phoneNumber.toString(),
            email = client.email
        )

        AppButton(
            text = "Creer une fiche de mission",
            onclick = {
                onClickNavToCreateMission()
            },
            Modifier
                .align(Alignment.End)
        )

        if(client.hasMission == true){

            OutlinedCard(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, colorResource(R.color.ButtonColor)),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ){
                Column (
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Row {
                        Text(
                            text = "Fiche de mission:",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "mission_order.pdf",
                            fontSize = 14.sp,
                            textDecoration = TextDecoration.Underline,
                            color = Color.Blue,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .clickable {
                                    onClickNavToPdf()
                                }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ClientInfoCard(
    name: String,
    address: String,
    city: String,
    postalCode: String,
    phoneNumber: String,
    email: String
) {
    OutlinedCard(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, colorResource(R.color.ButtonColor)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.ButtonColor),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider(color = Color.Gray, thickness = 1.dp)

            InfoRow(label = "Adresse", value = address)
            InfoRow(label = "Ville", value = "$city - $postalCode")
            InfoRow(label = "Téléphone", value = phoneNumber)
            InfoRow(label = "Email", value = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConsultClientScreenPreview() {
    AcEnvironnementComposeTheme {
        ConsultClientContent(
            client = Client(
                id = 1,
                firstName = "John",
                lastName = "Doe",
                address = "123 Main Street",
                ville = "Paris",
                postalCode = "75000",
                phoneNumber = 1234567890,
                email = "johndoe@example.com",
                gender = 1,
                true
            ),
            onClickNavToCreateMission = {},
            {}
        )
    }
}