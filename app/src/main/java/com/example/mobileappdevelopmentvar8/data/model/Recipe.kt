package com.example.mobileappdevelopmentvar8.data.model

data class Recipe(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val caloriesPerServing: Int
)