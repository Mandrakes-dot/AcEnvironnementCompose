package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import com.example.acenvironnementcompose.R
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme


@Composable
fun AppOutlinedCard(
    onClick:()->Unit,
    textContent:String,
    icon:ImageVector
    ){


        OutlinedCard (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.CardColor)

        ),
        modifier = Modifier
            .height(270.dp)
            .width(230.dp),
        onClick = onClick,
        border = BorderStroke(2.dp, colorResource(R.color.ButtonColor))
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            text = textContent,
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold
            ),
            fontSize = 20.sp
        )
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 50.dp)
                .size(80.dp),

        )
        }
    }


@Preview(showBackground = true)
@Composable
fun AppOutlinedCardPreview() {
    AcEnvironnementComposeTheme {
        AppOutlinedCard({},"text", icon = Icons.Default.Add)
    }
}