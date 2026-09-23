package com.example.gamelog.model

/** Videojuego del catálogo con su información principal. */
data class Game(
    val title: String,
    val developer: String,
    val description: String,
    val releaseYear: Int,
    val rating: Double,
    val imageUrl: String
)
