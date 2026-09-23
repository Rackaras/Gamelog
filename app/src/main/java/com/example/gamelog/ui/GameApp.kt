package com.example.gamelog.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.gamelog.data.GameDataSource
import com.example.gamelog.model.Game
import com.example.gamelog.ui.screens.GameCatalogScreen
import com.example.gamelog.ui.screens.GameDetailScreen
import com.example.gamelog.ui.screens.GameHomeScreen

/**
 * Componente STATEFUL: es el único dueño del estado de navegación.
 *
 * Aplica State Hoisting: el estado (pantalla actual y juego seleccionado) vive aquí
 * y se baja a las pantallas stateless como datos; los eventos suben como lambdas.
 */
@Composable
fun GameApp(games: List<Game> = GameDataSource.games) {
    var currentScreen by remember { mutableStateOf(GameScreen.Home) }
    var selectedGame by remember { mutableStateOf<Game?>(null) }

    // Botón "atrás" del sistema: Detalle -> Catálogo -> Inicio.
    BackHandler(enabled = currentScreen != GameScreen.Home) {
        currentScreen = when (currentScreen) {
            GameScreen.Detail -> GameScreen.Catalog
            else -> GameScreen.Home
        }
    }

    when (currentScreen) {
        GameScreen.Home -> GameHomeScreen(
            onViewCatalogClick = { currentScreen = GameScreen.Catalog }
        )

        GameScreen.Catalog -> GameCatalogScreen(
            games = games,
            onGameClick = { game ->
                selectedGame = game
                currentScreen = GameScreen.Detail
            },
            onBackClick = { currentScreen = GameScreen.Home }
        )

        GameScreen.Detail -> selectedGame?.let { game ->
            GameDetailScreen(
                game = game,
                onBackClick = { currentScreen = GameScreen.Catalog }
            )
        }
    }
}
