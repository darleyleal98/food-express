package com.darleyleal.aluvery.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.aluvery.model.Product
import com.darleyleal.aluvery.sampledata.sampleProducts

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ListAllProducts(products: List<Product> = sampleProducts) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Todos os produtos",
                    fontSize = 28.sp
                )
            })
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), modifier = Modifier.padding(top = 122.dp)
        ) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }
}
