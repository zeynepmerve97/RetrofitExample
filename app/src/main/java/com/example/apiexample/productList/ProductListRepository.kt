package com.example.apiexample.productList

import com.example.apiexample.network.response.ProductList
import retrofit2.Call

interface ProductListRepository {
    fun getProducts() : Call<ProductList>
}