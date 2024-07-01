package repository

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import models.PokeData
import source.PokeDeckRemoteDataSource

class PokeDeckRepositoryImpl(
    private val pokeDeckRemoteDataSource: PokeDeckRemoteDataSource
) : PokeDeckRepository {

    override suspend fun getDeckList(): PokeData {
        return try {
            pokeDeckRemoteDataSource.getDeckList()
        } catch (e: RedirectResponseException) {
            throw Exception(e.response.status.description)
        } catch (e: ClientRequestException) {
            throw Exception(e.response.status.description)
        } catch (e: ServerResponseException) {
            throw Exception(e.response.status.description)
        } catch (e: Exception) {
            throw Exception(e.message ?: "Something went wrong")
        }
    }

}