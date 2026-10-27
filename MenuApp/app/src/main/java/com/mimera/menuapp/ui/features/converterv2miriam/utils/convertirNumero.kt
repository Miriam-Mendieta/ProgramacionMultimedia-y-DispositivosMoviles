package com.mimera.menuapp.ui.features.converterv2miriam.utils

fun convertirNumero(numero: String, convertirABinario: Boolean): String {
    return try {
        if (convertirABinario) {
            Integer.toBinaryString(numero.toInt())
        } else {
            Integer.parseInt(numero, 2).toString()
        }
    } catch (_: Exception) {
        "Error: número inválido"
    }
}
