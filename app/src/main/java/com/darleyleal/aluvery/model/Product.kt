package com.darleyleal.aluvery.model

import java.math.BigDecimal

data class Product (
    val name: String,
    val price: BigDecimal,
    val image: String? = null
)