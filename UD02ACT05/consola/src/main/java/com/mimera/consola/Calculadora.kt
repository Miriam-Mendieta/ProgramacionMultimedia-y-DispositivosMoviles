package com.mimera.consola
/*
    EJERCICIO 9
    Declarar una clase llamada Calculadora que reciba en el constructor dos valores de tipo Double.
    Hacer la clase abierta para que sea heredable
    Definir las responsabilidades de sumar, restar, multiplicar, dividir e imprimir.
    Declarar luego una clase llamada CalculadoraCientifica que herede de Calculadora y añada las
    responsabilidades de calcular el cuadrado del primer número y la raíz cuadrada.

 */
open class Calculadora(var num1: Double, var num2: Double) {
    fun sumar(): Double = num1 + num2
    fun restar(): Double = num1 - num2
    fun multiplicar(): Double = num1 * num2
    fun dividir(): Double {
        if (num2 == 0.0) {
            throw IllegalArgumentException("No se puede dividir entre cero.")
        }
        return num1 / num2
    }

    fun imprimir() {
        println("Número 1: $num1")
        println("Número 2: $num2")
        println("Suma: ${sumar()}")
        println("Resta: ${restar()}")
        println("Multiplicación: ${multiplicar()}")
        println("División: ${dividir()}")
    }
}

class CalculadoraCientifica(num1: Double, num2: Double) : Calculadora(num1, num2) {
    fun cuadrado(): Double = num1 * num1
    fun raizCuadrada(): Double {
        if (num1 < 0) {
            throw IllegalArgumentException("No se puede calcular la raíz de un número negativo.")
        }
        return kotlin.math.sqrt(num1)
    }
}

//----------------------------------------------------------------

fun main() {
    val calc = Calculadora(10.0, 5.0)
    calc.imprimir()

    println("*********************")

    val cientifica = CalculadoraCientifica(9.0, 3.0)
    cientifica.imprimir()
    println("Cuadrado del primero: ${cientifica.cuadrado()}")
    println("Raíz cuadrada del primero: ${cientifica.raizCuadrada()}")
}