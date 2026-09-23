package com.example.mobileappdevelopmentvar8.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar8.data.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    fun fetchRecipe() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getRecipes()

                for (recipe in response.recipes) {
                    Log.d(
                        "RetrofitLog",
                        "ID: ${recipe.id} | " +
                                "Название: ${recipe.name} | " +
                                "Ингредиенты: ${recipe.ingredients.joinToString(", ")} | " +
                                "Калории: ${recipe.caloriesPerServing}"
                    )
                }
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}