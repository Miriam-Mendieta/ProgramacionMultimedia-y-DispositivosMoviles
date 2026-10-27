package com.mimera.menuapp.ui.features.profileyou.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


// Función Composable para mostrar una tarjeta de imagen con un botón de "Me gusta"
@Composable
fun Images(imageRes: Int, isLiked: Boolean, onLikeClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.size(140.dp, 160.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Imagen de fondo de la galería
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Imagen de galería",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Botón interactivo con el icono de corazón en la esquina inferior derecha
            IconButton(
                onClick = onLikeClick,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Dar like",
                    tint = if (isLiked) Color.Red else Color.Black
                )

            }
        }
    }
}