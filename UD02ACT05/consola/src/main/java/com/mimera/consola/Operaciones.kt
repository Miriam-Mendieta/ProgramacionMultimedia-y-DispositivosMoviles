package com.mimera.consola

/*
    EJERCICIO 5
    Plantear una clase Operaciones que en un método solicite la carga de 2 enteros
    y posteriormente llame a otros dos métodos que calculen su suma y producto.
 */
class Operaciones{
    private var num1: Int = 0
    private var num2: Int = 0

    fun cargar() {
        num1 = pedirEntero("Ingrese el primer entero: ")
        num2 = pedirEntero("Ingrese el segundo entero: ")

        suma()
        producto()
    }
    private fun pedirEntero(mensaje: String): Int {
        while (true) {
            print(mensaje)
            val entrada = readln().trim()

            if (entrada.isEmpty()) {
                println("[ERROR] La entrada no puede estar vacía.\n")
                continue
            }

            try {
                return entrada.toInt()
            } catch (_: NumberFormatException) {
                println("[ERROR] Debe ingresar un número entero válido.\n")
            }
        }
    }

    fun suma() {
        val resultado = num1 + num2
        println("\nLa suma de $num1 + $num2 es: $resultado")
    }

    fun producto() {
        val resultado = num1 * num2
        println("El producto de $num1 * $num2 es: $resultado")
    }
}

// ------------------------------------------------------------
fun main() {
    println("\n========== OPERACIONES ==========")
    val operaciones = Operaciones()
    operaciones.cargar()
    println("=================================")
}