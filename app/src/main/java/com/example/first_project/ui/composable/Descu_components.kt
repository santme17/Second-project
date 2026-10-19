package com.example.first_project.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first_project.R

// ---------- Colores ----------
val Morado = Color(0xFF4B3FC4)
val Naranja = Color(0xFFFF9800)

// ---------- Modelos ----------
data class Categoria(
    val nombre: String,
    val icono: ImageVector,
    val fondo: Color,
    val tinte: Color
)

data class Destino(
    val nombre: String,
    val tipo: String,
    val rating: Double,
    val descripcion: String,
    @DrawableRes val imagen: Int
)

// ---------- Datos de ejemplo ----------
val categorias = listOf(
    Categoria("Montaña", Icons.Filled.Landscape, Color(0xFFE8E0FF), Color(0xFF5B3FD0)),
    Categoria("Bosque", Icons.Filled.Park, Color(0xFFDFF3E3), Color(0xFF2E7D32)),
    Categoria("Playa", Icons.Filled.BeachAccess, Color(0xFFDDF1FB), Color(0xFF0288D1)),
    Categoria("Ciudad", Icons.Filled.LocationCity, Color(0xFFFFE9CC), Color(0xFFF57C00)),
    Categoria("Favoritos", Icons.Filled.Favorite, Color(0xFFFFE0EC), Color(0xFFE91E63))
)

// Agrega laguna.jpg, playa.jpg y centro.jpg en res/drawable
val destinos = listOf(
    Destino("Laguna Azul", "Naturaleza", 4.8, "Un paraíso natural rodeado de montañas.", R.drawable.laguna),
    Destino("Playa del Sol", "Playa", 4.6, "Aguas cristalinas y arena blanca.", R.drawable.playa),
    Destino("Centro Histórico", "Cultura", 4.7, "Historia y arquitectura en un solo lugar.", R.drawable.centro)
)

// ---------- Image con texto encima ----------
@Composable
fun ImagenDestacada(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(170.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.laguna),
            contentDescription = "Explora",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color.Black.copy(alpha = 0.55f))
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text("Explora", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Lugares increíbles\ncerca de ti", color = Color.White, fontSize = 13.sp)
        }
    }
}

@Composable
fun CategoriaItem(categoria: Categoria, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable { /* TODO: filtrar por categoría */ }
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(categoria.fondo),
            contentAlignment = Alignment.Center
        ) {
            Icon(categoria.icono, contentDescription = categoria.nombre, tint = categoria.tinte)
        }
        Spacer(Modifier.height(4.dp))
        Text(categoria.nombre, fontSize = 12.sp)
    }
}

@Composable
fun DestinoItem(destino: Destino, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { /* TODO: abrir detalle */ }
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(destino.imagen),
            contentDescription = destino.nombre,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 100.dp, height = 80.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(destino.nombre, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("${destino.tipo} • ", fontSize = 12.sp, color = Color.Gray)
                Icon(Icons.Filled.Star, null, tint = Naranja, modifier = Modifier.size(14.dp))
                Text(" ${destino.rating}", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Text(
                destino.descripcion,
                fontSize = 12.sp,
                color = Color.DarkGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.DarkGray
        )
    }
}