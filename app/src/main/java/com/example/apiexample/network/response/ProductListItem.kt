package com.example.apiexample.network.response

data class ProductListItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingX,
    val title: String
)