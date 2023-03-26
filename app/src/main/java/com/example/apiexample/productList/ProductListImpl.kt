package com.example.apiexample.productList

import com.example.apiexample.network.ProductApi.productService
import com.example.apiexample.network.response.ProductList
import retrofit2.Call

class ProductListImpl : ProductListRepository {

    override fun getProducts(): Call<ProductList> {
        return productService.getProduct()
    }

}