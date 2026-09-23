package com.example.gamelog.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamelog.data.GameDataSource
import com.example.gamelog.model.Game
import com.example.gamelog.ui.components.GameDetailCard
import com.example.gamelog.ui.components.GameTopAppBar
import com.example.gamelog.ui.theme.GamelogTheme

/** Pantalla con el detalle del videojuego seleccionado. */
@Composable
fun GameDetailScreen(
    game: Game,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = { GameTopAppBar(title = "Detalle", onBackClick = onBackClick) }
    ) { innerPadding ->
        GameDetailCard(
            game = game,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameDetailScreenPreview() {
    GamelogTheme {
        GameDetailScreen(
            game = GameDataSource.games.first(),
            onBackClick = {}
        )
    }
}
