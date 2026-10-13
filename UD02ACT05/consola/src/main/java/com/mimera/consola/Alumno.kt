package com.mimera.consola

/*
    EJERCICIO 3
    Implementar una clase llamada Alumno que tenga como propiedades su nombre
    y su nota. Definir los métodos para inicializar sus propiedades por teclado,
    imprimirlos y mostrar un mensaje si está regular (nota mayor o igual a 4)
    Definir dos objetos de la clase Alumno.
 */
class Alumno(var nombre: String, var nota: Int) {
    init {
        // require() verifica la condición; si es falsa, lanza IllegalArgumentException
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío." }
        require(nota in 0..10) { "La nota debe estar entre 0 y 10." }

    }

    fun mostrar() {
        println("Alumno: $nombre | Nota: $nota")
    }

    fun evaluarNota() = println(
        if (nota >= 4)
            "Alumno $nombre: REGULAR (Aprobado)."
        else
            "Alumno $nombre: NO REGULAR (No aprobado)."
    )
}

//============================================================================
fun main() {
    // PRIMER ALUMNO ----------------------------
    println("\n--- REGISTRO DEL ALUMNO 1 ---")
    try {
        val alumno1 = ingresarAlumno()
        println("\nResultados:")
        alumno1.mostrar()
        alumno1.evaluarNota()
    } catch (e: IllegalArgumentException) {
        println("[Error]: ${e.message}")
    }

    // SEGUNDO ALUMNO -------------------------------
    println("\n--- REGISTRO DEL ALUMNO 2 ---")
    try {
        val alumno2 = ingresarAlumno()
        println("\nResultados:")
        alumno2.mostrar()
        alumno2.evaluarNota()
    } catch (e: IllegalArgumentException) {
        println("[ERROR]: ${e.message}")
    }

    println("\n==========================================")
}

fun ingresarAlumno(): Alumno {
    print("Ingrese el nombre del alumno: ")
    val nombre = readln().trim().uppercase()

    print("Ingrese la nota del alumno (0-10): ")
    val nota = readln().toIntOrNull()
        ?: throw IllegalArgumentException("Debe ingresar un número válido.")

    return Alumno(nombre, nota)
}
