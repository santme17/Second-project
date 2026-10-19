package com.example.first_project.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_project.ui.section.Body
import com.example.first_project.ui.section.Header

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header()
        Body(modifier = Modifier.weight(1f))
        // Footer() -> el diseño "Descubre" no lo usa; déjalo comentado o agrégalo si lo quieres
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 780)
@Composable
fun HomePreview() {
    Home()
}