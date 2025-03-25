package com.example.acenvironnementcompose.ui.ui.screen.archive

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.comon.AppTopBar
import com.example.acenvironnementcompose.ui.ui.screen.add_client.AddClientScreen


@Composable
fun ArchiveScreen(){
    ArchiveContent()
}


@Composable
fun ArchiveContent(

){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.MainBackGround))
    ) {
        AppTopBar("archives")

        OutlinedTextField(
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp),
            value = "Search",
            onValueChange = {}
        )

        LazyColumn (
            modifier = Modifier
                .padding(top = 10.dp)
                .weight(1f)
        ) {

        }
    }
}



@Preview(showBackground = true)
@Composable
fun ArchiveScreenPreview() {
    AcEnvironnementComposeTheme {
        ArchiveScreen()
    }
}