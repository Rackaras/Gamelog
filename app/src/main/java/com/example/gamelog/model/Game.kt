package com.example.gamelog.model

/**
 * Entidad principal del catálogo Gamelog.
 *
 * @property title Título del videojuego (texto).
 * @property developer Estudio desarrollador (texto).
 * @property description Descripción del videojuego (texto).
 * @property releaseYear Año de lanzamiento (numérico).
 * @property rating Calificación sobre 10 (numérico).
 * @property imageUrl URL de la portada (imagen).
 */
data class Game(
    val title: String,
    val developer: String,
    val description: String,
    val releaseYear: Int,
    val rating: Double,
    val imageUrl: String
)
