package com.darleyleal.aluvery.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.darleyleal.aluvery.R
import com.darleyleal.aluvery.model.Product
import com.darleyleal.aluvery.ui.components.ProductsSection

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(sections: Map<String, List<Product>>, navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "FoodExpress", fontSize = 32.sp)
                },
                actions = {
                    IconButton(onClick = { navController.navigate("searchTextField") }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.barra_de_pesquisa),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                    IconButton(onClick = { navController.navigate("listAllProducts") }) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = stringResource(R.string.cone_de_listagem_de_produtos)
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 116.dp)
        ) {

            for (section in sections) {
                val title = section.key
                val product = section.value

                item {
                    ProductsSection(title = title, products = product)
                }
            }
        }
    }
}