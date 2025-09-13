package com.example.milau

fun main() {
    println(" Registro de calificaciones")
    println("=".repeat(40))

    val analizador = AnalizadorCalificaciones()
    println("\nRegistra 7 calificaciones")
    for (i in 1..7) {
        var calificacionValida = false

        while (!calificacionValida) {
            try {
                print("Calificacion $i: ")
                val input = readln()

                if (input.isBlank()) {
                    println(" Error")
                    continue
                }

                val calificacion = input.toFloat()

                if (calificacion < 0f || calificacion > 10f) {
                    println("Error")
                    continue
                }

                analizador.agregarCalificacion(calificacion)
                calificacionValida = true

            } catch (e: NumberFormatException) {
                println("Error")
            }
        }
    }

    println("\n" + "=".repeat(40))
    println(" RESULTADOS")
    println("=".repeat(40))

    println("\n Calificaciones registrada:")
    analizador.obtenerTodas().forEachIndexed { index, calif ->
        println("   Materia ${index + 1}: $calif")
    }

    println("\n Estadisticas:")
    println(" Promedio final: %.2f".format(analizador.calcularPromedio()))
    println(" Materias aprobadas: ${analizador.contarAprobadas()}")
    println(" Materias reprobadas: ${analizador.contarReprobadas()}")
    println(" Calificacion mas alta: ${analizador.obtenerMaxima() ?: "N/A"}")
    println(" Calificacion mas baja: ${analizador.obtenerMinima() ?: "N/A"}")
}