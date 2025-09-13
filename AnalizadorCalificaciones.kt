package com.example.milau
//Clase AnalizadorCalificaciones
class AnalizadorCalificaciones {
    private val calificaciones = mutableListOf<Float>()

    fun agregarCalificacion(calificacion: Float) {
        require(calificacion in 0.0f..10.0f) {
            "La calificacion debe estar entre 0 y 10"
        }
        calificaciones.add(calificacion)
    }

    fun calcularPromedio(): Float {
        require(calificaciones.isNotEmpty()) {
            "No hay calificaciones para calcular"
        }
        return String.format("%.2f", calificaciones.average()).toFloat()
    }

    fun contarAprobadas(): Int {
        return calificaciones.count { it >= 7.0f }
    }

    fun contarReprobadas(): Int {
        return calificaciones.count { it < 7.0f }
    }

    fun obtenerMaxima(): Float? {
        return calificaciones.maxOrNull()
    }

    fun obtenerMinima(): Float? {
        return calificaciones.minOrNull()
    }

    fun obtenerTodas(): List<Float> {
        return calificaciones.toList()
    }

    fun limpiarCalificaciones() {
        calificaciones.clear()
    }
}