package com.example.first_project.ui.composable

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Con_text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        modifier = modifier,
        color = color
    )
}