package com.darleyleal.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.aluvery.model.Product
import com.darleyleal.aluvery.sampledata.sampleSections
import com.darleyleal.aluvery.ui.screens.HomeScreen
import com.darleyleal.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductsSection(title: String, products: List<Product>) {
    Column {
        Text(
            text = title,
            modifier = Modifier.padding(
                start = 8.dp, end = 8.dp
            ),
            fontSize = 24.sp,
            fontWeight = FontWeight(700)
        )
        LazyRow(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }
}