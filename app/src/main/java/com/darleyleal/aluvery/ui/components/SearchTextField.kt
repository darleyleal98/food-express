@file:Suppress("UNUSED_EXPRESSION")

package com.darleyleal.aluvery.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darleyleal.aluvery.R
import com.darleyleal.aluvery.model.Product
import com.darleyleal.aluvery.sampledata.sampleProducts

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@Composable
fun SearchTextField(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var listProducts: List<Product> = sampleProducts

    Scaffold(
        topBar = {
            SearchBar(
                query = text,
                onQueryChange = { text = it },
                onSearch = { println("Performing search on query: $it") },
                active = active,
                onActiveChange = { false },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = stringResource(
                            R.string.barra_de_pesquisa
                        )
                    )
                },
                trailingIcon = {
                    if (text.isNotBlank()) {
                        Icon(
                            modifier = Modifier.clickable { text = "" },
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(R.string.icone_de_fechar)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                shape = RoundedCornerShape(100.dp),
                placeholder = { Text(text = stringResource(R.string.o_que_voce_procura)) }
            ) {}
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 1),
            modifier = Modifier.padding(top = 122.dp)
        ) {
            when {
                text.isBlank() -> {
                    items(listProducts) { product ->
                        CardProductItem(product)
                    }
                }

                else -> {
                    items(listProducts) { product ->

                        val containsSoughtValue = remember(text) {
                            product.name.contains(text, true) ||
                                    product.description?.contains(text, true) == true
                        }

                        if (containsSoughtValue) {
                            CardProductItem(product)
                        }
                    }
                }
            }
        }
    }
}