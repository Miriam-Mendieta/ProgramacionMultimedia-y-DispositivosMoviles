package com.mimera.menuapp.ui.features.converterv2miriam.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimera.menuapp.ui.features.converterv2miriam.components.AppTextField
import com.mimera.menuapp.ui.features.converterv2miriam.components.CabeceraUsuario
import com.mimera.menuapp.ui.features.converterv2miriam.components.LabelText
import com.mimera.menuapp.ui.features.converterv2miriam.components.PrimaryButton
import com.mimera.menuapp.ui.features.converterv2miriam.components.ConversionModeSwitch
import com.mimera.menuapp.ui.features.converterv2miriam.utils.convertirNumero

@Composable
fun ConverterScreen() {

    var number by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var convertToBinary by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // foto y nombre
        CabeceraUsuario()

        // Texto encima del campo
        LabelText("Introduce un número entero")

        // Campo donde el usuario escribe el número
        AppTextField(number) { number = it }

        Spacer(modifier = Modifier.height(24.dp))

//--------------------------------------------------------------------------------
        // A decimal / A binario
        ConversionModeSwitch(
            number = number,
            convertToBinary = convertToBinary,
            onModeChange = { convertToBinary = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

//-------------------------------------------------------------------------
        Text(
            text = "Conversión:",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )

        // Color del resultado según el modo
        val resultColor = if (convertToBinary) Color(0xFF00AA00) else Color(0xFF0066FF)

        // Resultado final
        Text(
            text = result,
            fontSize = 24.sp,
            color = resultColor,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
//---------------------------------------------------------------------------------
        // Botones Convertir / borrar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 70.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            PrimaryButton(
                text = "Convertir",
                modifier = Modifier.weight(1f),
                isSelected = true
            ) {
                result = if (number.isBlank()) {
                    "Introduce un número válido"
                } else {
                    convertirNumero(number, convertToBinary)
                }
            }

            PrimaryButton(
                text = "Borrar",
                modifier = Modifier.weight(1f),
                isSelected = false
            ) {
                number = ""
                result = ""
            }
        }
    }
}

