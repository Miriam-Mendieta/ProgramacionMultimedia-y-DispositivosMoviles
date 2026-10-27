package com.mimera.menuapp.ui.features.registro.components

import android.R.attr.singleLine
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onClearError: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // TÍTULO
        Text(
            text = "EMAIL",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Black
            ),
            color = Color.Black,
        )

        // CAMPO DE EMAIL
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it) //limpia el error al escribir
                onClearError()
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("user@domain.com") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Icono Email"
                )
            },
            isError = value.isNotEmpty() &&
                    !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()
        )
    }
}
