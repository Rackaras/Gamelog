package com.example.gamelog.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamelog.data.GameDataSource
import com.example.gamelog.model.Game
import com.example.gamelog.ui.theme.GamelogTheme

/** Tarjeta con toda la información de un videojuego. */
@Composable
fun GameDetailCard(game: Game, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        GameCoverImage(imageUrl = game.imageUrl, contentDescription = game.title)
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            Text(
                text = game.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider()
            GameAttributeRow(label = "Desarrollador", value = game.developer)
            GameAttributeRow(label = "Año de lanzamiento", value = game.releaseYear.toString())
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Calificación",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1f)
                )
                GameRatingBadge(rating = game.rating)
            }
            HorizontalDivider()
            Text(
                text = "Descripción",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = game.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/** Fila que muestra un dato del videojuego con su etiqueta. */
@Composable
fun GameAttributeRow(label: String, value: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(1f)
        )
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailCardPreview() {
    GamelogTheme {
        GameDetailCard(
            game = GameDataSource.games[5],
            modifier = Modifier.padding(16.dp)
        )
    }
}
