package com.mimera.consola
/*
    EJERCICIO 10
    Declarar una clase abstracta Cuenta y dos subclases CajaAhorra y PlazoFijo.
    Definir las propiedades y métodos comunes entre una caja de ahorro y un plazo fijo
    y agruparlos en la clase Cuenta.
    Una caja de ahorro y un plazo fijo tienen un nombre de titular y un monto.
    Un plazo fijo añade un plazo de imposición en días y una tasa de interés.
    Hacer que la caja de ahorro no genera intereses.
    En la función main del programa definir un objeto de la clase CajaAhorro
    y otro de la clase PlazoFijo.

 */
abstract class Cuenta (var nombreTitular: String, var monto: Double ) {
    abstract fun mostrarInteres()
    fun mostrarDatos() {
        println("Titular: $nombreTitular | Monto: €$monto")
    }
}


class CajaAhorro(nombreTitular: String, monto: Double) : Cuenta(nombreTitular, monto){
    override fun mostrarInteres() {
        println("La Caja de Ahorro no genera intereses.")
    }
}

class PlazoFijo(
    nombreTitular: String,
    monto: Double,
    var plazoDias: Int,
    var tasaIntereses: Double
) : Cuenta(nombreTitular, monto) {

    override fun mostrarInteres() {
        val interesGanado = monto * (tasaIntereses / 100.0) * (plazoDias / 365.0)
        println("Plazo fijo a $plazoDias días (Tasa: $tasaIntereses%). " +
                "Interés generado: € ${String.format("%.2f", interesGanado)}")

    }
}


//----------------
fun main() {
    println("\n========== REGISTRO DE CUENTAS BANCARIAS ===========\n")

    // Instancia de CajaAhorro ----------------------------------------------
    val cajaAhorro = CajaAhorro("María Pérez", 150000.0)
    cajaAhorro.mostrarDatos()
    cajaAhorro.mostrarInteres()

    println("\n*****************************************************\n")

    // Instancia de PlazoFijo -------------------------------------------------------------------------------
    val plazoFijo = PlazoFijo("Juan Gómez", 100000.0, 30, 15.0)
    plazoFijo.mostrarDatos()
    plazoFijo.mostrarInteres()

    println("\n*****************************************************\n")
}

/*
El interés se calcula como:
interes = monto*(tasa/100)*(plazo/365)

 */