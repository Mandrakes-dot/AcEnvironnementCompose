package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme


@Composable
fun AppDropDownMenu(
    onClick:(String)->Unit,
    modifier: Modifier,
    title: String
) {

    var text by remember { mutableStateOf("") }
    var expanded by remember  { mutableStateOf(false) }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "$title :",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )

            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(R.color.white)
                ),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .clickable {
                        expanded = !expanded
                    }
                    .padding(end = 15.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Text(
                        text = text,
                        modifier = Modifier
                            .padding(start = 14.dp)

                    )
                }
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Client") },
                    onClick = {
                        text = "Client"
                        onClick(text)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Client Potentiel") },
                    onClick = {
                        text = "Client Potentiel"
                        onClick(text)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Diag en cours") },
                    onClick = {
                        text = "Diag en cours"
                        onClick(text)
                        expanded = false
                    }
                )
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun AppDropDownMenuPreview() {
    AcEnvironnementComposeTheme {
        AppDropDownMenu({},Modifier,"Test")
    }
}