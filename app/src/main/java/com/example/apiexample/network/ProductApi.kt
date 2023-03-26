package com.example.apiexample.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


internal object ProductApi {


    private val productGson: Gson by lazy {
        GsonBuilder().create()
    }

    private lateinit var httpClient: OkHttpClient.Builder

    val productService: ProductService by lazy {

        httpClient = getOkHttpClient()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(productGson))
            .client(httpClient.build())
            .build()

        retrofit.create(ProductService::class.java)
    }

    private fun getOkHttpClient() : OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(60 , TimeUnit.SECONDS)
        httpClient.readTimeout(60 , TimeUnit.SECONDS)
        httpClient.writeTimeout(60 , TimeUnit.SECONDS)

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(httpLoggingInterceptor)
        //ProductApi.httpClient.addInterceptor(ProductInterceptor())

        return httpClient

    }

    class ProductInterceptor: Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("Content-Type", "application/json")

            return  chain.proceed(requestBuilder.build())
        }
    }

}