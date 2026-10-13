package com.mimera.consola
/*
    EJERCICIO 11
    Declarar una clase Persona con las propiedades nombre y edad, definir como
    métodos su impresión y otra que retorna true si es mayor de edad o false en caso
    contrario
    En la función main definir un array con cuatro elementos de tipo Persona. Calcular
    cuantas personas son mayores de edad.
 */
class PersonaMayor (var nombre: String, var edad: Int){
    init {
        // require() verifica la condición; si es falsa, lanza IllegalArgumentException
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío." }
        require(edad in 0..120) { "Edad no válida." }

    }
    fun mostrar() {
        println("Nombre: $nombre | Edad: $edad")
    }

    fun esMayorEdad(): Boolean { return edad >= 18
    }
}


//-----------------------------------------------------
fun main() {
    val personas = arrayOf(
        PersonaMayor("Ana", 17),
        PersonaMayor("Luis", 22),
        PersonaMayor("María", 15),
        PersonaMayor("Carlos", 30)
    )

    // Mostrar cada persona
    println("========== LISTA DE PERSONAS ==========")
    personas.forEach { it.mostrar() }

    // Contar mayores de edad
    val mayores = personas.count { it.esMayorEdad() }

    println("\nCantidad de personas mayores de edad: $mayores")
    print("***************************************")
}

