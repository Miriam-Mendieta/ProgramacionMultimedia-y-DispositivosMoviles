package com.mimera.consola
/*
    EJERCICIO 1
    Implementaremos una clase llamada Persona que tendrá como propiedades (variables) su nombre
    y edad, y tres métodos (funciones), uno de dichos métodos inicializará las propiedades
    del nombre y la edad, otro método mostrará en la pantalla el contenido de las propiedades
    y por último uno que imprima si es mayor de edad.
 */
class Persona {
    var nombre: String = ""
    var edad: Int = 0

    fun inicializar(nombre: String, edad: Int) {

        if (nombre.isEmpty() || nombre.length < 2) {
            throw IllegalArgumentException("Nombre inválido")
        }
        if (edad !in 0..120) {
            throw IllegalArgumentException("Edad inválida")
        }
        this.nombre = nombre
        this.edad = edad
    }

    fun mostrar() {
        println("Nombre: $nombre")
        println("Edad: $edad")
    }

    fun esMayorDeEdad() {
        if (edad >= 18) {
            println("$nombre es mayor de edad")
        } else {
            println("$nombre es menor de edad")
        }
    }
}

fun main() {
    // --- Prueba 1: Datos válidos (Mayor de edad) ---
    println("\n**********************")
    try {
        val persona1 = Persona()
        persona1.inicializar("Miriam", 65)
        persona1.mostrar()
        persona1.esMayorDeEdad()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // --- Prueba 2: Datos válidos (Menor de edad) ---
    println("**********************")
    try {
        val persona2 = Persona()
        persona2.inicializar("Mikel", 15)
        persona2.mostrar()
        persona2.esMayorDeEdad()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // --- Prueba 3: Datos inválidos ---
    println("**********************")
    try {
        val persona3 = Persona()
        persona3.inicializar("", -1)
        persona3.mostrar()
        persona3.esMayorDeEdad()
    } catch (e: IllegalArgumentException) {
        println("Error al registrar la persona: ${e.message}")
    }
    println("**********************")
}

