package com.example.retrofit_api_response

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ProductService {
    @GET("products")
    suspend fun fetchProducts(): ArrayList<Product>

    companion object{
        fun getInstance() : ProductService{
            val retrofit = Retrofit.Builder()
            val productSevices = retrofit.baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductService::class.java)

            return productSevices
        }
    }
}