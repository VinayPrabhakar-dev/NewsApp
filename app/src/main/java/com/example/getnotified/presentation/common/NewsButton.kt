package com.example.getnotified.presentation.common

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.getnotified.R

@Composable
fun NewsButton(
    text: String,
    onClick:() -> Unit
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.md_theme_onPrimaryContainer),
            contentColor = colorResource(id = R.color.md_theme_primaryContainer)
        ),
        shape = MaterialTheme.shapes.small
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun NewsTextButton(
    text: String,
    onClick:() -> Unit
) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.md_theme_onBackground_mediumContrast)
        )
    }
}