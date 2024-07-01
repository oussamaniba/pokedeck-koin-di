package pokelist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import models.Result

@Composable
fun PokeList(
    modifier: Modifier = Modifier,
    viewModel: PokeViewModel,
) {

    val pokeData = viewModel.getList.collectAsState()

    LazyColumn(
        modifier = modifier
    ) {
        items(pokeData.value?.results?.size ?: 0) { poke ->
            PokeItem(pokeData.value?.results?.get(poke) ?: Result(
                name = "Undefined",
                url = "Undefined"
            ))
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun PokeItem(result: Result) {
    ListItem {
        Text(result.name)
    }
}

