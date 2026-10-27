package com.mimera.menuapp.ui.features.registro.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BotonesRegistro(
    formularioCompleto: Boolean,
    formularioTieneDatos: Boolean,
    onLimpiar: () -> Unit,
    onRegistrar: () -> Unit,
    onClearError: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        // BOTÓN LIMPIAR
        Button(
            onClick = {
                onLimpiar()
                onClearError()   // limpia error al borrar
            },
            enabled = formularioTieneDatos,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (formularioTieneDatos) Color(0xFF7251AF) else Color(0xFFCCCCCC),
                contentColor = Color.White
            )
        ) {
            Text("Borrar formulario")
        }

        // BOTÓN REGISTRAR
        Button(
            onClick = {
                onClearError()   // limpia error antes de validar
                onRegistrar()    // se ejecuta el registro
            },
            enabled = formularioCompleto,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (formularioCompleto) Color(0xFF7251AF) else Color(0xFFCCCCCC),
                contentColor = Color.White
            )
        ) {
            Text("Registrarse")
        }
    }
}
