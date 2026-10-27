package com.mimera.menuapp.ui.features.converterv2miriam.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ConversionModeSwitch(
    number: String,
    convertToBinary: Boolean,
    onModeChange: (Boolean) -> Unit
) {
    val enabled = number.isNotBlank()

    val gray = Color(0xFFA6A5A8)
    val purple = Color(0x209063E0)
    val purpleSelected = Color(0xFF6A3FB5)

    val leftBg = when {
        !enabled -> gray
        !convertToBinary -> purpleSelected
        else -> purple
    }

    val rightBg = when {
        !enabled -> gray
        convertToBinary -> purpleSelected
        else -> purple
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        // Texto izquierda
        ModeTextBox(
            text = "A decimal",
            backgroundColor = leftBg,
            modifier = Modifier
                .weight(1f)
                .padding(end = 14.dp)
        )

        // Switch central
        Switch(
            checked = convertToBinary,
            onCheckedChange = { if (enabled) onModeChange(it) },
            enabled = enabled
        )

        //  texto derecha
        ModeTextBox(
            text = "A binario",
            backgroundColor = rightBg,
            modifier = Modifier
                .weight(1f)
                .padding(start = 14.dp)
        )
    }
}
