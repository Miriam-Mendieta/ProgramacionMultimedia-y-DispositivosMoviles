package com.mimera.menuapp.ui.features.registro.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FechaNacimientoField(
    formattedDate: String,
    onDateClick: () -> Unit,
    modifier: Modifier = Modifier,
    onClearError: () -> Unit = {}
) {
    Text(
        text = "Fecha de Nacimiento",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = Color.Black
    )
    OutlinedTextField(
        value = formattedDate,
        onValueChange = {},
        enabled = false,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClearError()
                onDateClick() },
        placeholder = { Text("Selecciona fecha") }
    )
}
