package com.mimera.convertidordecimal_binario_hexadecimal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimera.convertidordecimal_binario_hexadecimal.ui.theme.ConvertidorDecimal_Binario_HexadecimalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConvertidorDecimal_Binario_HexadecimalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ConversorScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// función para la pantalla del conversor
@Composable
fun ConversorScreen(modifier: Modifier = Modifier) {
    // número entero aleatorio generado (es null al iniciar)
    var numeroGenerado by remember { mutableStateOf<Int?>(null) }

    // texto del resultado formateado en binario o hexadecimal
    var textoResultado by remember { mutableStateOf("") }

    // DISPOSICIÓN VISUAL PRINCIPAL
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Título de la aplicación
        Text(
            text = "Conversor numérico",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.orange) // Color naranja
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Cambia de función y texto según si existe un número generado
        Button(
            onClick = {
                if (numeroGenerado == null) {
                    numeroGenerado = (1..255).random()
                    textoResultado = "Número generado: $numeroGenerado"
                } else {
                    numeroGenerado = null
                    textoResultado = ""
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8C00)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (numeroGenerado == null) "Haz click para generar un número" else "Borrar todo y reiniciar",
                fontSize = 16.sp
            )
        }
        // solo si "numeroGenerado" NO ES NULO
        if (numeroGenerado != null) {

            // Texto que muestra el número generado actualmente
            Text(
                text = "Número actual: $numeroGenerado",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            // Botón para convertir a Binario
            Button(
                onClick = {
                    numeroGenerado?.let { numero ->
                        val binario = Integer.toBinaryString(numero)
                        textoResultado = "Binario: $binario"
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Convertir a binario", fontSize = 16.sp)
            }

            // Botón para convertir a Hexadecimal
            Button(
                onClick = {
                    numeroGenerado?.let { numero ->
                        val hexadecimal = Integer.toHexString(numero).uppercase()
                        textoResultado = "Hexadecimal: $hexadecimal"
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Convertir a hexadecimal", fontSize = 16.sp)
            }

            // Texto donde se muestra el resultado final de la conversión
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = textoResultado,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun ConversorScreenPreview() {
        ConvertidorDecimal_Binario_HexadecimalTheme {
            ConversorScreen()
        }
    }
