package com.example.acenvironnementcompose.ui.ui.comon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.example.acenvironnementcompose.ui.ui.screen.login.LoginScreen
import org.w3c.dom.Text

@Composable
fun AppTextField(
    value: String,
    labelText :@Composable (() -> Unit),
    onValueChange: (String) -> Unit,

){
    Column  (
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = labelText,
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AppTextFieldPreview() {
    AcEnvironnementComposeTheme {
        AppTextField("login",{ Text("awda") },{"awda"})
    }
}