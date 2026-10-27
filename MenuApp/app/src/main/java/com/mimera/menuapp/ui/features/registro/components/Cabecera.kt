package com.mimera.menuapp.ui.features.registro.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Cabecera() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFA659DE)) // fondo morado
            .padding(top = 25.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFE0316D))// fondo rojo del cuadrado
                .border(
                    width = 4.dp,
                    color = Color(0xFF520BA6),

                )
               .padding(horizontal = 44.dp, vertical = 5.dp)
        ) {
            Text(
                text = "Regístrate en la APP",
                color = Color.Black,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}