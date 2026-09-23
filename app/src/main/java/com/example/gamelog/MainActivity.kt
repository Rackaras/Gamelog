package com.example.gamelog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.gamelog.data.GameDataSource
import com.example.gamelog.model.Game
import com.example.gamelog.ui.GameScreen
import com.example.gamelog.ui.screens.GameCatalogScreen
import com.example.gamelog.ui.screens.GameDetailScreen
import com.example.gamelog.ui.screens.GameHomeScreen
import com.example.gamelog.ui.theme.GamelogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamelogTheme {
                GameApp()
            }
        }
    }
}

/** Controla la pantalla actual y el videojuego seleccionado. */
@Composable
fun GameApp(games: List<Game> = GameDataSource.games) {
    var currentScreen by remember { mutableStateOf(GameScreen.Home) }
    var selectedGame by remember { mutableStateOf<Game?>(null) }

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
