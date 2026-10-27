package com.mimera.menuapp.ui.features.registro.screens


import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.*

object RegistrationValidation {

    // Solo letras con acentos, ñ, ü y espacios. Máx. 15 caracteres.
    private val nameRegex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñÜü\\s]{1,15}$")

    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidName(name: String): Boolean {
        return nameRegex.matches(name)
    }

    fun isValidPhone(phone: String): Boolean {
        // Solo números, mínimo 9 dígitos
        return phone.matches(Regex("^[0-9]{9,15}$"))
    }

    fun formatDate(millis: Long?): String {
        if (millis == null) return ""
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return formatter.format(Date(millis))
    }
}
