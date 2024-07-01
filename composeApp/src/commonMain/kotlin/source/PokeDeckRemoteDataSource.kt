package source

import models.PokeData


interface PokeDeckRemoteDataSource {
    suspend fun getDeckList(): PokeData
}