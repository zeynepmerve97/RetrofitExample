package com.example.apiexample.network

import com.example.apiexample.network.response.ProductList

import retrofit2.Call
import retrofit2.http.GET



interface ProductService {

    @GET("products")
    fun getProduct(): Call<ProductList>

}