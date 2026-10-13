package com.mimera.consola
/*
    EJERCICIO 7
    Declarar un data class llamado Persona que almacene el nombre y la edad.
    Sobreescribir el método toString para retornar un String con la concatenación del
    nombre y la edad separadas por una coma.
 */

data class PersonaData(var nombre: String, var edad: Int){
    override fun toString(): String {
        return "\n\t$nombre, $edad"
    }
}

//---------------------------------------------
fun main() {
    val persona = PersonaData("Mikel", 18)
    println(persona)
    println("*****************")
}