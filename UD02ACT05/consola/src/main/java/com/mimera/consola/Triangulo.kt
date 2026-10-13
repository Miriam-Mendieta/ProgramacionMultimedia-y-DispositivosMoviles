package com.mimera.consola
/*
    EJERCICIO 2
    Implementar una clase que cargue los lados de un triángulo e implemente los
    siguientes métodos: inicializar las propiedades, imprimir el valor del lado mayor
    y otro método que muestre si es equilátero o no.
 */
class Triangulo(val lado1: Double, val lado2: Double, val lado3: Double) {

    init {
        if (lado1.isNaN() || lado2.isNaN() || lado3.isNaN() || lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw IllegalArgumentException("Ningún lado puede estar vacío, no definido o ser menor/igual a cero.")
        }
    }

    //imprimir el valor mayor
    fun ladoMayor() {
        val mayor = listOf(lado1, lado2, lado3).maxOrNull()
        println("El lado mayor mide: $mayor")
    }

    //Muestra si es equilatero o no
    fun esEquilatero() = println(

        //.all: recorre la lista y devuelve 'true'-->si TODOS elementos cumplen la condición
        //it == lado1: Expresión lambda donde 'it' representa cada lado  comparado con el primero.
        if (listOf(lado1, lado2, lado3).all { it == lado1 })
            "El triángulo es equilátero (todos sus lados son iguales)."
        else
            "El triángulo NO es equilátero."
    )
}
//=========================================================================================

fun main() {
    // --- PRUEBA 1: Triángulo Equilátero (Lados iguales) ---
    println("**********************")
    println("PRUEBA 1: Lados iguales")
    try {
        val t1 = Triangulo(5.0, 5.0, 5.0)
        t1.ladoMayor()
        t1.esEquilatero()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // --- PRUEBA 2: Triángulo Escaleno ---
    println("**********************")
    println("PRUEBA 2: Lados diferentes")
    try {
        val t2 = Triangulo(3.0, 7.5, 4.2)
        t2.ladoMayor()
        t2.esEquilatero()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // --- PRUEBA 3: Triángulo Isósceles ---
    println("**********************")
    println("PRUEBA 3: Dos lados iguales (Isósceles)")
    try {
        val t3 = Triangulo(10.0, 10.0, 5.0)
        t3.ladoMayor()
        t3.esEquilatero()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // --- PRUEBA 4: Control de errores con datos inválidos ---
    println("**********************")
    println("PRUEBA 4: Intento con lados inválidos (<= 0)")
    try {
        val t4 = Triangulo(0.0, 0.0, 100.3)
        t4.ladoMayor()
        t4.esEquilatero()
    } catch (e: IllegalArgumentException) {
        // Captura la excepción y muestra el mensaje de error esperado
        println("Error capturado correctamente: ${e.message}")
    }
    println("**********************")
}