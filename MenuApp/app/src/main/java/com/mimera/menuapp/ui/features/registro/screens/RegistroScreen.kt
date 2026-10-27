package com.mimera.menuapp.ui.features.registro.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mimera.menuapp.ui.features.registro.components.*

@Composable
fun RegistroScreen() {

    // Estados del formulario
    var email by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var primerApellido by remember { mutableStateOf("") }
    var segundoApellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var fechaNacimientoMillis by remember { mutableStateOf<Long?>(null) }

    val categoriasDeportes = listOf("Fútbol", "Baloncesto", "Tenis", "Natación")
    val categoriasTecnologia = listOf("Móviles", "IA", "Videojuegos", "Ciencia")

    var selectedDeportes by remember { mutableStateOf(setOf<String>()) }
    var selectedTecnologia by remember { mutableStateOf(setOf<String>()) }

    var showDatePicker by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    // --- LÓGICA DEL FORMULARIO ---
    val formularioCompleto =
        email.isNotBlank() &&
                nombre.isNotBlank() &&
                primerApellido.isNotBlank() &&
                segundoApellido.isNotBlank() &&
                telefono.isNotBlank() &&
                fechaNacimientoMillis != null

    val formularioTieneDatos =
        email.isNotBlank() ||
                nombre.isNotBlank() ||
                primerApellido.isNotBlank() ||
                segundoApellido.isNotBlank() ||
                telefono.isNotBlank() ||
                fechaNacimientoMillis != null ||
                selectedDeportes.isNotEmpty() ||
                selectedTecnologia.isNotEmpty()

    fun limpiar() {
        email = ""
        nombre = ""
        primerApellido = ""
        segundoApellido = ""
        telefono = ""
        fechaNacimientoMillis = null
        selectedDeportes = emptySet()
        selectedTecnologia = emptySet()
        errorMessage = null
    }

    fun registrar() {

        when {
            !RegistrationValidation.isValidEmail(email) ->
                errorMessage = "El email no es válido."

            !RegistrationValidation.isValidName(nombre) ->
                errorMessage = "El nombre debe tener máximo 15 letras y solo caracteres válidos."

            !RegistrationValidation.isValidName(primerApellido) ->
                errorMessage = "El primer apellido no es válido."

            !RegistrationValidation.isValidName(segundoApellido) ->
                errorMessage = "El segundo apellido no es válido."

            !RegistrationValidation.isValidPhone(telefono) ->
                errorMessage = "El teléfono debe contener solo números y mínimo 9 dígitos."

            fechaNacimientoMillis == null ->
                errorMessage = "Debes seleccionar una fecha de nacimiento."

            else -> {
                errorMessage = null
                showSuccessDialog = true
            }
        }
        }

        // --- UI ---
        Scaffold(
            topBar = {
                Column {
                    Cabecera()

                    errorMessage?.let { message ->
                        ErrorBanner(message)
                    }

                    Spacer(Modifier.height(3.dp))
                }
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.height(130.dp)
                ) {
                    PiePagina()
                }
            }
        ) { innerPadding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .imePadding(),        //se necesita para teclado
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){

                item {
                    EmailField(
                        value = email,
                        onValueChange = { email = it },
                        onClearError = { errorMessage = null },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    NombreField(
                        label = "Introduce tu nombre",
                        value = nombre,
                        onValueChange = { nombre = it },
                        onClearError = { errorMessage = null },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    ApellidoField(
                        title = "Primer Apellido",
                        label = "Introduce tu primer Apellido",
                        value = primerApellido,
                        onChange = { primerApellido = it },
                        onClearError = { errorMessage = null },
                    )
                }

                item {
                    ApellidoField(
                        title = "Segundo Apellido",
                        label = "Introduce tu segundo Apellido",
                        value = segundoApellido,
                        onChange = { segundoApellido = it },
                        onClearError = { errorMessage = null },
                    )
                }

                item {
                    TelefonoField(
                        value = telefono,
                        onValueChange = { telefono = it },
                        onClearError = { errorMessage = null },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    FechaNacimientoField(
                        formattedDate = RegistrationValidation.formatDate(fechaNacimientoMillis),
                        onDateClick = { showDatePicker = true },
                        onClearError = { errorMessage = null },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    Text("Selecciona tus favoritos", style = MaterialTheme.typography.titleMedium)
                }

                item {
                    FavoritosChips(
                        titulo = "Deportes",
                        items = categoriasDeportes,
                        seleccionados = selectedDeportes,
                        onChange = { selectedDeportes = it }
                    )
                }

                item {
                    FavoritosChips(
                        titulo = "Tecnología",
                        items = categoriasTecnologia,
                        seleccionados = selectedTecnologia,
                        onChange = { selectedTecnologia = it }
                    )
                }

                item {
                    BotonesRegistro(
                        formularioCompleto = formularioCompleto,
                        formularioTieneDatos = formularioTieneDatos,
                        onLimpiar = { limpiar() },
                        onRegistrar = { registrar() }
                    )
                }
            }
        }

        // --- DATE PICKER ---
        if (showDatePicker) {
            val datePickerState = rememberDatePickerState()
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        fechaNacimientoMillis = datePickerState.selectedDateMillis
                        showDatePicker = false
                    }) { Text("Aceptar") }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) { Text("Cancelar") }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

        // si todo esta bien
        if (showSuccessDialog) {
            AlertDialog(
                onDismissRequest = { showSuccessDialog = false },

                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Éxito",
                            tint = Color(0xFF4CAF50), // verde éxito
                            modifier = Modifier.size(70.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Registro en la APP",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                },

                text = {
                    Text(
                        text = "El registro en la App se ha realizado correctamente.",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },

                confirmButton = {
                    Button(onClick = {
                        limpiar()            // limpia el formulario
                        showSuccessDialog = false
                    }) {
                        Text("Aceptar")
                    }
                }
            )
        }
    }

    @Composable
    fun ErrorBanner(message: String) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color(0xFF0047FF)), // borde azul
            colors = CardDefaults.cardColors(
                containerColor = Color.White // fondo blanco
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = message,
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }


