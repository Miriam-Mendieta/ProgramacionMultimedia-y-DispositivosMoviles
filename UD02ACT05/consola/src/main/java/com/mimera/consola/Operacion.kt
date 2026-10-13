package com.mimera.consola
/*
   EJERCICIO 8
   Declarar un enum class que represente las cuatro operaciones básicas, asociar a
   cada constante un String con el signo de la operación.
   Definir una clase Operación que defina tres propiedades, las dos primeras deben
   ser los números y la tercera el tipo de operación.
 */
enum class TipoOperacion(val signo: String) {
    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    DIVISION("/")
}

class Operacion(val num1: Double, val num2: Double, val tipo: TipoOperacion) {

    fun calcular(): Double {
        return when (tipo) {
            TipoOperacion.SUMA -> num1 + num2
            TipoOperacion.RESTA -> num1 - num2
            TipoOperacion.MULTIPLICACION -> num1 * num2
            TipoOperacion.DIVISION -> {
                if (num2 == 0.0) {
                    throw IllegalArgumentException("No se puede dividir por cero.")
                } else {
                    num1 / num2
                }
            }
        }
    }

    fun mostrarResultado() {
        println("$num1 ${tipo.signo} $num2 = ${calcular()}")
    }
}

//------------------------------------------------------
fun main() {
    println("\n===== OPERACIONES BÁSICAS =====")
    val op1 = Operacion(10.0, 5.0, TipoOperacion.SUMA)
    op1.mostrarResultado()

    val op2 = Operacion(8.0, 2.0, TipoOperacion.MULTIPLICACION)
    op2.mostrarResultado()

    val op3 = Operacion(10.0, 5.0, TipoOperacion.RESTA)
    op3.mostrarResultado()

    val op4 = Operacion(8.0, 2.0, TipoOperacion.DIVISION)
    op4.mostrarResultado()

    try {
        val op5 = Operacion(10.0, 0.0, TipoOperacion.DIVISION)
        op5.mostrarResultado()
    } catch (e: IllegalArgumentException) {
        println("[ERROR]: ${e.message}")
    }
}