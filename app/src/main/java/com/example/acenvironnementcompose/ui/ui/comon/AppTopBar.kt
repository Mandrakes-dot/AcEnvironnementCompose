package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppTopBar(
    text: String,

){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .clickable {

            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = "",
            modifier = Modifier
                .padding(start = 10.dp)
        )
        Text(
            text = text,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
}