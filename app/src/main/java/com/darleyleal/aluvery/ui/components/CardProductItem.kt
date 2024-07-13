package com.darleyleal.aluvery.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.darleyleal.aluvery.R
import com.darleyleal.aluvery.extensions.toBrazilianCurrency
import com.darleyleal.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product
) {
    Card(
        Modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        var expanded by remember { mutableStateOf(false) }

        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable { expanded = !expanded },
                placeholder = painterResource(id = R.drawable.placeholder_image),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(900),
                    maxLines = 2,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight(400)
                )
                AnimatedVisibility(visible = expanded) {
                    product.description?.let {
                        Text(
                            modifier = Modifier.padding(top = 16.dp),
                            text = it,
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight(400),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 3
                        )
                    }
                }
            }
        }
    }
}