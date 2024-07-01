package repository

import models.PokeData

interface PokeDeckRepository {

    suspend fun getDeckList(): PokeData

}