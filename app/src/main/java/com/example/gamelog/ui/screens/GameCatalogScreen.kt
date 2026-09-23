package com.example.gamelog.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamelog.data.GameDataSource
import com.example.gamelog.model.Game
import com.example.gamelog.ui.components.GameItem
import com.example.gamelog.ui.components.GameTopAppBar
import com.example.gamelog.ui.theme.GamelogTheme

/** Pantalla con el listado de videojuegos del catálogo. */
@Composable
fun GameCatalogScreen(
    games: List<Game>,
    onGameClick: (Game) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = { GameTopAppBar(title = "Catálogo", onBackClick = onBackClick) }
    ) { innerPadding ->
        GameList(
            games = games,
            onGameClick = onGameClick,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

/** Lista desplazable de videojuegos. */
@Composable
fun GameList(
    games: List<Game>,
    onGameClick: (Game) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(items = games, key = { it.title }) { game ->
            GameItem(game = game, onClick = onGameClick)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameCatalogScreenPreview() {
    GamelogTheme {
        GameCatalogScreen(
            games = GameDataSource.games,
            onGameClick = {},
            onBackClick = {}
        )
    }
}
