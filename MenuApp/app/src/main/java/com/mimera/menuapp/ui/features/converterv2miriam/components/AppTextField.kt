package com.mimera.menuapp.ui.features.converterv2miriam.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppTextField(
    value: String,
    onChange: (String) -> Unit
) {
    androidx.compose.material3.TextField(
        value = value,
        onValueChange = onChange,
        label = { Text("Número a convertir") },
        leadingIcon = {
            Text(
                text = "#",
                fontSize = 20.sp
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFD6C8EE),
            unfocusedContainerColor = Color(0xFFD9C9F5),

        ),

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp)
    )
}
