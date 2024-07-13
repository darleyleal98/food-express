package com.darleyleal.aluvery.sampledata

import com.darleyleal.aluvery.model.Product
import java.math.BigDecimal

val sampleCandies = listOf(
    Product(
        name = "Chocolate",
        price = BigDecimal("4.99"),
        image = "https://images.hindustantimes.com/img/2022/08/09/original/c2_(1)_1660036277995.jpg?q=70",
        description = "Delicioso chocolate ao leite, perfeito para qualquer momento do dia."
    ),
    Product(
        name = "Sorvete",
        price = BigDecimal("5.99"),
        image = "https://www.oppskriftskroken.no/wp-content/uploads/2023/06/Hjemmelaget-jordbaeris.jpg",
        description = "Sorvete de morango artesanal, refrescante e saboroso."
    ),
    Product(
        name = "Banoffee",
        price = BigDecimal("12.99"),
        image = "https://img.cybercook.com.br/receitas/327/receita-de-banoffee-1.jpeg",
        description = "Torta Banoffee feita com banana, doce de leite e chantilly."
    )
)

val sampleDrinks = listOf(
    Product(
        name = "Suco Detox",
        price = BigDecimal("5.99"),
        image = "https://uvn-brightspot.s3.amazonaws.com/assets/vixpt/s/suco-detox-frutas-0816-1400x800.jpg",
        description = "Suco detox de frutas frescas, ideal para revitalizar seu dia."
    ),
    Product(
        name = "Café Latte",
        price = BigDecimal("4.99"),
        image = "https://th.bing.com/th/id/R.7d002ca6b750a3bb73e58206fa966903?rik=3qFVi%2fdVQKiO%2bQ&pid=ImgRaw&r=0",
        description = "Café Latte cremoso, perfeito para começar a manhã com energia."
    ),
    Product(
        name = "Café Mocaccino",
        price = BigDecimal("7.99"),
        image = "https://cdn.utopiahotels.com/assets/images/pages/006lagunabarfamilyy-lg.jpg",
        description = "Café Mocaccino com chocolate, uma deliciosa combinação de sabores."
    )
)

val sampleProducts: List<Product> = listOf(
    Product(
        name = "Salada de frutas",
        price = BigDecimal("19.99"),
        image = "https://th.bing.com/th/id/OIP.0OhLcz-wv5UySlE6X0gQBQHaE8?rs=1&pid=ImgDetMain",
        description = "Salada de frutas frescas, saudável e nutritiva."
    ),
    Product(
        name = "Torta de legumes",
        price = BigDecimal("14.99"),
        image = "https://1.bp.blogspot.com/-cxkNrlYgsyY/XUbxm6-ayFI/AAAAAAAAMOo/fkIVmItzy4MA9GX7-QDCYZXX1XLG99Y3QCLcBGAs/s1600/Torta%2BIntegral%2Bde%2BLegumes.jpg",
        description = "Torta integral de legumes, uma opção leve e deliciosa."
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("8.99"),
        image = "https://www.ocu.org/-/media/ocu/images/home/alimentacion/alimentos/pizzas_selector_1600x900.jpg?rev=6a81e278-07fc-4e95-9ba1-361063f35adf&hash=B8B1264AB6FC3F4B1AE140EB390208CD",
        description = "Pizza de queijo com molho de tomate, ideal para qualquer ocasião."
    )
) + sampleDrinks + sampleCandies

val sampleSections = mapOf (
    "Promoções" to sampleProducts,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks
)