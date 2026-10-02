package com.example.mobileappdevelopmentvar8.data.service

import com.example.mobileappdevelopmentvar8.data.model.Product
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductsApiService {
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product

    @PUT("products/{id}")
    suspend fun updateProduct(@Path("id") id: Int, @Body product: Product): Product
}
