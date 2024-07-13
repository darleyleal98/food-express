package com.darleyleal.aluvery.model

import java.math.BigDecimal

data class Product (
    var name: String,
    val price: BigDecimal,
    val image: String? = null,
    val description: String? = null
)