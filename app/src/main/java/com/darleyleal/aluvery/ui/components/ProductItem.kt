package com.darleyleal.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.darleyleal.aluvery.R
import com.darleyleal.aluvery.extensions.toBrazilianCurrency
import com.darleyleal.aluvery.model.Product
import com.darleyleal.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp).background(Color.White)
        ) {
            val image = 125.dp
            Box(
                modifier = Modifier
                    .height(image)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.placeholder_image),
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
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
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                product = Product(
                    name = LoremIpsum(50).values.first(),
                    price = BigDecimal("14.99"),
                    image = "https://img.cybercook.com.br/receitas/327/receita-de-banoffee-1.jpeg"
                )
            )
        }
    }
}