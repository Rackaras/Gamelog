package com.example.gamelog.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamelog.data.GameDataSource
import com.example.gamelog.model.Game
import com.example.gamelog.ui.theme.GamelogTheme

/**
 * Ítem del catálogo (stateless): muestra un resumen del juego y notifica el tap
 * hacia arriba mediante [onClick].
 */
@Composable
fun GameItem(
    game: Game,
    onClick: (Game) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onClick(game) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        GameCoverImage(imageUrl = game.imageUrl, contentDescription = game.title)
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = game.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                GameRatingBadge(rating = game.rating, modifier = Modifier.padding(start = 8.dp))
            }
            Text(
                text = "${game.developer} · ${game.releaseYear}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = game.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameItemPreview() {
    GamelogTheme {
        GameItem(
            game = GameDataSource.games.first(),
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
