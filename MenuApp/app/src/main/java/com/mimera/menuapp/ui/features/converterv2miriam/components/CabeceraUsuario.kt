package com.mimera.menuapp.ui.features.converterv2miriam.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimera.menuapp.R


@Composable
fun CabeceraUsuario() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)                 // altura de la franja
            .background(Color(0xFF9063E0)), // color morado
        verticalAlignment = Alignment.CenterVertically
    ) {

    }

    // foto y nombre
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(4.dp, Color(0xFF0C9FE3), CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = "Miriam Mendieta",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
    }

    HorizontalDivider(
        thickness = 4.dp,
        color = Color(0xFF0C9FE3),
        )
}

