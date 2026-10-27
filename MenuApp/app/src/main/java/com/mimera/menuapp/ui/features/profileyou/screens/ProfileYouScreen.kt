package com.mimera.menuapp.ui.features.profileyou.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.PersonRemove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimera.menuapp.R
import com.mimera.menuapp.ui.features.profileyou.components.Hobbies
import com.mimera.menuapp.ui.features.profileyou.components.Images


@Composable
fun ProfileYouScreen() {

    var isFollowing by remember { mutableStateOf(false) }
    var contadorMensajes by remember { mutableIntStateOf(0) }
    var isLiked1 by remember { mutableStateOf(false) }
    var isLiked2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // foto y nombre
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.profile), "Foto de perfil", Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape), contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Miriam Mendieta",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // follow
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            if (!isFollowing) {
                FilledTonalButton(
                    onClick = { isFollowing = true },
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Icon(Icons.Default.PersonAdd, null)
                    Spacer(Modifier.width(8.dp))
                    Text("Follow")
                }
            } else {
                OutlinedButton(
                    onClick = { isFollowing = false },
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Icon(Icons.Default.PersonRemove, null)
                    Spacer(Modifier.width(8.dp))
                    Text("UnFollow")
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            BadgedBox(
                badge = {
                    if (contadorMensajes > 0) {
                        Badge { Text("$contadorMensajes") }
                    }
                }
            ) {
                IconButton(onClick = {
                    if (contadorMensajes > 0) contadorMensajes--
                }) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Mensajes sin leer"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        HorizontalDivider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // hobbies
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "HOBBIES",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // lista de hobbies
        Column(modifier = Modifier.fillMaxWidth()) {
            Hobbies(Icons.AutoMirrored.Filled.MenuBook, "Leer")
            Hobbies(Icons.Default.SportsEsports, "Nadar")
            Hobbies(Icons.Default.Group, "Tiempo de calidad con la familia")
            Hobbies(Icons.Default.Tv, "Mirar series")
            Hobbies(Icons.AutoMirrored.Filled.DirectionsWalk, "Senderismo")
            Hobbies(Icons.Default.People, "Juntada con amig@s")
        }

        Spacer(modifier = Modifier.height(24.dp))

        HorizontalDivider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // galería fotos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Images(
                imageRes = R.drawable.patinando,
                isLiked = isLiked1,
                onLikeClick = { isLiked1 = !isLiked1 }
            )
            Images(
                imageRes = R.drawable.playa,
                isLiked = isLiked2,
                onLikeClick = { isLiked2 = !isLiked2 }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // botón
        Button(
            onClick = { contadorMensajes++ },
            shape = RoundedCornerShape(50.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Incrementar contador de mensajes"
            )
            Text(
                text = "1",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


