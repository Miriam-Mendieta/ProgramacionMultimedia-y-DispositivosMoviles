package com.mimera.menuapp.ui.features.registro.components

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
fun ApellidoField(
    title: String,
    label: String,
    value: String,
    onChange: (String) -> Unit,
    onClearError: () -> Unit = {}   // permite limpiar error desde RegistroScreen
) {
    // TÍTULO ENCIMA
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = Color.Black
    )

    // CAMPO DE APELLIDO
    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length <= 15) {
                onChange(it)
                onClearError()   // limpia el error al escribir
            }
        },
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}
