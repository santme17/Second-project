package com.example.first_project.ui.section

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first_project.ui.composable.CategoriaItem
import com.example.first_project.ui.composable.DestinoItem
import com.example.first_project.ui.composable.ImagenDestacada
import com.example.first_project.ui.composable.Morado
import com.example.first_project.ui.composable.categorias
import com.example.first_project.ui.composable.destinos

@Composable
fun Body(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

        Spacer(Modifier.height(12.dp))

        // Image destacada
        ImagenDestacada(modifier = Modifier.padding(horizontal = 12.dp))

        Spacer(Modifier.height(12.dp))

        // LazyRow: categorías
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(categorias) { categoria ->
                CategoriaItem(categoria)
            }
        }

        Spacer(Modifier.height(12.dp))

        // Título de la sección
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Destinos populares",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                modifier = Modifier.weight(1f)
            )
            Text(
                "Ver todos",
                color = Morado,
                fontSize = 13.sp,
                modifier = Modifier.clickable { /* TODO */ }
            )
        }

        // LazyColumn: destinos
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(destinos) { destino ->
                DestinoItem(destino)
            }
        }
    }
}