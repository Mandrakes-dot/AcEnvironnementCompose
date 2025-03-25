package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.acenvironnementcompose.R


@Composable
fun AppButton(
    text: String,
    onclick:()->Unit,
    modifier: Modifier
){

    Button(
        onclick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.ButtonColor), // Background color
            contentColor = Color.White  // Text color
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
        )
    }
}