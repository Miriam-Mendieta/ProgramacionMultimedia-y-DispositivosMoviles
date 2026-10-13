package com.mimera.consola
import kotlin.random.Random

/*
    EJERCICIO 6
    Plantear una clase llamada Dado. Definir una propiedad privada llamada valor y
    tres métodos uno privado que dibuje una línea de asteríscos y otros dos públicos,
    uno que genere un número aleatorio entre 1 y 6 y otro que lo imprima llamando
    en este último al que dibuja la línea de asteríscos
 */
class Dado {
    private var valor: Int = 1

    // Método privado
    private fun dibujarLinea() {
        println("********************")
    }
    // Métodos públicos
    fun tirar() {
        valor = Random.nextInt(1, 7) // Genera un número entre 1 y 6
    }

    fun imprimir() {
        dibujarLinea()
        println("Valor del dado: $valor")
        dibujarLinea()
    }
}

//-------------------------------------------------
fun main() {
    val miDado = Dado()
    miDado.tirar()
    miDado.imprimir()
}

/*
// Método privado que dibuja N asteriscos en la misma línea
    private fun dibujarLinea(cantidad: Int) {
        println("*".repeat(cantidad))
    }
    fun imprimir() {
        print("Valor del dado: $valor   ")
        // Dibuja la línea con la cantidad de asteriscos según el valor
        dibujarLinea(valor)
    }
}
 */