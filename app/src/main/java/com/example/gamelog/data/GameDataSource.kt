package com.example.gamelog.data

import com.example.gamelog.model.Game

private fun steamCover(appId: Int) =
        "https://cdn.cloudflare.steamstatic.com/steam/apps/$appId/header.jpg"

/** Lista de videojuegos que se muestran en el catálogo. */
object GameDataSource {

    val games: List<Game> = listOf(
        Game(
            title = "Dark Souls: Remastered",
            developer = "FromSoftware",
            description = "Lordran agoniza bajo la maldición de los no muertos. Como elegido, " +
                "deberás atravesar un mundo interconectado lleno de peligros, derrotar a los " +
                "Señores de las Almas y decidir el destino de la Era del Fuego.",
            releaseYear = 2018,
            rating = 9.2,
            imageUrl = steamCover(570940)
        ),
        Game(
            title = "Dark Souls II: Scholar of the First Sin",
            developer = "FromSoftware",
            description = "Viaja al reino caído de Drangleic en busca de una cura para la " +
                "maldición. Incluye las tres expansiones de la corona perdida y nuevos " +
                "enemigos y encuentros reorganizados.",
            releaseYear = 2015,
            rating = 8.7,
            imageUrl = steamCover(335300)
        ),
        Game(
            title = "Dark Souls III",
            developer = "FromSoftware",
            description = "La llama se apaga y el mundo se desmorona. Los Señores de la Ceniza " +
                "han abandonado sus tronos y solo un Latente puede devolverlos para enlazar " +
                "el fuego una última vez.",
            releaseYear = 2016,
            rating = 9.0,
            imageUrl = steamCover(374320)
        ),
        Game(
            title = "Elden Ring",
            developer = "FromSoftware",
            description = "Un RPG de acción de mundo abierto ambientado en las Tierras " +
                "Intermedias. Como Sinluz, reúne los fragmentos del Círculo de Elden y " +
                "conviértete en Señor del Círculo.",
            releaseYear = 2022,
            rating = 9.6,
            imageUrl = steamCover(1245620)
        ),
        Game(
            title = "Sekiro: Shadows Die Twice",
            developer = "FromSoftware",
            description = "En el Japón de la era Sengoku, el shinobi Lobo debe rescatar a su " +
                "joven señor y vengarse de su enemigo, dominando un combate basado en la " +
                "postura y los contraataques precisos.",
            releaseYear = 2019,
            rating = 9.1,
            imageUrl = steamCover(814380)
        ),
        Game(
            title = "Fable: The Lost Chapters",
            developer = "Lionhead Studios",
            description = "Crece desde niño hasta convertirte en héroe en el mundo de Albion. " +
                "Cada decisión, buena o malvada, cambia tu apariencia, tu reputación y la " +
                "forma en que los aldeanos reaccionan ante ti.",
            releaseYear = 2005,
            rating = 8.5,
            imageUrl = steamCover(204030)
        ),
        Game(
            title = "Fable Anniversary",
            developer = "Lionhead Studios",
            description = "Remasterización en alta definición del Fable original, con " +
                "gráficos renovados, controles mejorados y el contenido completo de The " +
                "Lost Chapters.",
            releaseYear = 2014,
            rating = 7.8,
            imageUrl = steamCover(288470)
        ),
        Game(
            title = "Fable III",
            developer = "Lionhead Studios",
            description = "Lidera una revolución contra tu hermano, el tirano rey Logan, y " +
                "gobierna Albion. Tus promesas como revolucionario serán puestas a prueba " +
                "cuando llegue el momento de reinar.",
            releaseYear = 2011,
            rating = 7.5,
            imageUrl = steamCover(105400)
        )
    )
}
