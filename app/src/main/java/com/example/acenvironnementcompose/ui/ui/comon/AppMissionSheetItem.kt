package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.acenvironnementcompose.R


@Composable
fun AppMissionSheetItem(){

    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.CardColor)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .width(230.dp)
            .clickable { },
        border = BorderStroke(2.dp, colorResource(R.color.ButtonColor)),
    ){
    }
}
