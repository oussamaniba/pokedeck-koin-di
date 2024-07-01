package source

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import models.PokeData
import modules.client

class PokeDeckRemoteDataSourceImpl : PokeDeckRemoteDataSource {

    override suspend fun getDeckList(): PokeData {
        val response = client.get {
            url("pokemon")
        }
        return response.body<PokeData>()
    }

}