package com.mimera.menuapp.ui.features.registro.utils

object ValidadorRegistro {

    private val nombreRegex = Regex("^[A-Za-zÁÉÍÓÚÜÑáéíóúüñ ]{1,15}$")
    private val telefonoRegex = Regex("^[0-9]{9,15}$")

    fun validarEmail(email: String): Boolean =
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun validarNombre(nombre: String): Boolean =
        nombreRegex.matches(nombre)

    fun validarTelefono(telefono: String): Boolean =
        telefonoRegex.matches(telefono)

    fun validarFormulario(
        email: String,
        nombre: String,
        apellido1: String,
        apellido2: String,
        telefono: String,
        fechaNacimiento: String
    ): String? {

        if (!validarEmail(email)) return "Email no válido"
        if (!validarNombre(nombre)) return "Nombre no válido"
        if (!validarNombre(apellido1)) return "Primer apellido no válido"
        if (!validarNombre(apellido2)) return "Segundo apellido no válido"
        if (!validarTelefono(telefono)) return "Teléfono no válido"
        if (fechaNacimiento.isBlank()) return "Fecha de nacimiento obligatoria"

        return null
    }
}