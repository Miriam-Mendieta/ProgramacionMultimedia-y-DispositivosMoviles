package com.mimera.menuapp.ui.features.registro.utils


object RegistroLogic {

    fun formularioCompleto(
        email: String,
        nombre: String,
        apellido1: String,
        apellido2: String,
        telefono: String,
        fechaNacimiento: String
    ): Boolean =
        email.isNotBlank() &&
                nombre.isNotBlank() &&
                apellido1.isNotBlank() &&
                apellido2.isNotBlank() &&
                telefono.isNotBlank() &&
                fechaNacimiento.isNotBlank()

    fun formularioTieneDatos(
        email: String,
        nombre: String,
        apellido1: String,
        apellido2: String,
        telefono: String,
        fechaNacimiento: String,
        favoritos1: Set<String>,
        favoritos2: Set<String>
    ): Boolean =
        email.isNotBlank() ||
                nombre.isNotBlank() ||
                apellido1.isNotBlank() ||
                apellido2.isNotBlank() ||
                telefono.isNotBlank() ||
                fechaNacimiento.isNotBlank() ||
                favoritos1.isNotEmpty() ||
                favoritos2.isNotEmpty()

    fun limpiar(
        onClear: (
            email: String,
            nombre: String,
            apellido1: String,
            apellido2: String,
            telefono: String,
            fechaNacimiento: String,
            favoritos1: Set<String>,
            favoritos2: Set<String>
        ) -> Unit
    ) {
        onClear(
            "", "", "", "", "", "",
            emptySet(), emptySet()
        )
    }
}
