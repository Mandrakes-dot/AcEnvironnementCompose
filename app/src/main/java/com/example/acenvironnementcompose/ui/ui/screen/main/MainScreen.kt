package com.example.acenvironnementcompose.ui.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.logic.room.Client
import com.example.acenvironnementcompose.logic.viewmodel.MainViewModel
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.comon.AppClientItem
import com.example.acenvironnementcompose.ui.ui.comon.AppMainCarousel
import com.example.acenvironnementcompose.ui.ui.screen.navigation.Screen


@Composable
fun MainScreen(
    navController: NavHostController,
    viewmodel: MainViewModel
    ) {


    val clientList by viewmodel.clientList.collectAsState()

    MainContent(null,
         onClick2 = {
            navController.navigate(Screen.AddClient.route)
        },
        list = clientList,
        onClickNavToClient = { clientId ->
            navController.navigate("consult_client/$clientId")
        }
    )
}


@Composable
fun MainContent(
    model:String?,
    onClick2:()-> Unit,
    onClickNavToClient:(Int)->Unit,
    list : List<Client>
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.MainBackGround))
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(start = 20.dp)
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ){ AsyncImage(
            model = model,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            placeholder = rememberVectorPainter(Icons.Default.AccountCircle)
            )
            Text(
                text = "Bonjour! Test",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
        AppMainCarousel(
            titleCardDevis = "Creer devis",
            titleCardArchives = "Archives",
            titleCardModifyUser = "Profil Utilisateur",
            titleCardAddClient = "Ajouter un client",
            onClickGoToCreateDevis = {
                //clientList
            },
            onClickGoToArchives = {

            },
            onClickModifyUser = {

            },
            onClickGoToAddClient = {
                onClick2()
            },
            iconDevis = Icons.Default.AddChart,
            iconArchives = Icons.Default.Assignment,
            iconModifyUser = Icons.Default.Person,
            iconAddClient = Icons.Default.PersonAdd
        )
        Spacer(Modifier.padding(5.dp))

        OutlinedTextField(
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(bottom = 10.dp),

            value = "Search",
            onValueChange = {}
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(list){ client ->
            AppClientItem(client = client, onClick = {
                onClickNavToClient(client.id ?: 0)
            })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AcEnvironnementComposeTheme {
//       MainContent("")
    }
}