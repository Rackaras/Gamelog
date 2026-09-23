package com.example.gamelog

import com.example.gamelog.data.GameDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GameDataSourceTest {

    @Test
    fun catalogHasBetweenSixAndEightGames() {
        assertTrue(GameDataSource.games.size in 6..8)
    }

    @Test
    fun gameTitlesAreUnique() {
        val titles = GameDataSource.games.map { it.title }
        assertEquals(titles.size, titles.toSet().size)
    }

    @Test
    fun gamesHaveValidAttributes() {
        GameDataSource.games.forEach { game ->
            assertTrue(game.imageUrl.startsWith("https://"))
            assertTrue(game.rating in 0.0..10.0)
            assertTrue(game.releaseYear > 1970)
        }
    }
}
