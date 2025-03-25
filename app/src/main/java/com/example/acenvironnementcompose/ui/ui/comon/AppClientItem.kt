package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.logic.room.Client
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme


@Composable
fun AppClientItem(client: Client?,onClick:()->Unit){

    var sex = ""

    when(client?.gender){
        1 -> {sex += "Mr"}
        2 -> {sex += "Mme"}
    }

    OutlinedCard(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, colorResource(R.color.ButtonColor)),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 20.dp)
            .padding(bottom = 10.dp)
            .clickable {
                onClick()
            }
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .background(colorResource(R.color.CardColor))
                .padding(start = 15.dp)
        ){
            Text(
                text = "$sex ${client?.lastName} ${client?.firstName}",
                modifier = Modifier.padding(end = 60.dp)
            )

            InfoRow(
                label = "Statut",
                value = "",
                )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppClientItemPreview() {
    AcEnvironnementComposeTheme {
        AppClientItem(null,{})
    }
}