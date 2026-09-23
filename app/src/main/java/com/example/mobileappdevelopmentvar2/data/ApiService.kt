package com.example.mobileappdevelopmentvar8.data

import com.example.mobileappdevelopmentvar8.data.model.RecipeResponse
import com.example.mobileappdevelopmentvar8.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse

    @POST("users/add")
    suspend fun createUser(@Body user: User): User
}