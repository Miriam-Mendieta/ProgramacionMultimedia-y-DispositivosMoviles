package com.mimera.menuapp.ui.features.registro.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NombreField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onClearError: () -> Unit = {}
) {
    Text(
        text = "Nombre",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = Color.Black
    )

    OutlinedTextField(
        value = value,
        onValueChange = { if (it.length <= 15) onValueChange(it); onClearError() },
        label = { Text(label) },
        singleLine = true,
        modifier = modifier
    )
}
