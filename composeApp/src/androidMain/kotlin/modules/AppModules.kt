package modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pokelist.PokeViewModel
import repository.PokeDeckRepository
import repository.PokeDeckRepositoryImpl
import source.PokeDeckRemoteDataSource
import source.PokeDeckRemoteDataSourceImpl

actual val pokeModule = module {
    factory<PokeDeckRemoteDataSource> { PokeDeckRemoteDataSourceImpl() }
    factory<PokeDeckRepository> { PokeDeckRepositoryImpl(get()) }
}

actual val viewModelModules = module {
    viewModel <PokeViewModel> {
        PokeViewModel(get())
    }
}
