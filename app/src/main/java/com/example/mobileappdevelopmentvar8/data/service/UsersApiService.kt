package com.example.mobileappdevelopmentvar8.data.service

import com.example.mobileappdevelopmentvar8.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UsersApiService {
    @POST("users/add")
    suspend fun createUser(@Body user: User): User

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): User

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body user: User): User
}
