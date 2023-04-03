package com.example.apiexample.productList

import com.example.apiexample.network.ProductApi.productService
import com.example.apiexample.network.response.ProductList
import retrofit2.Call
import javax.inject.Inject

class ProductListImpl @Inject constructor() : ProductListRepository {

    override fun getProducts(): Call<ProductList> {
        return productService.getProduct()
    }

}