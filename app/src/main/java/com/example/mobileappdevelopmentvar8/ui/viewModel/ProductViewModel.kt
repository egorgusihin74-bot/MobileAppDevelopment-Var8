package com.example.mobileappdevelopmentvar8.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar8.data.RetrofitClient
import com.example.mobileappdevelopmentvar8.data.model.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    fun getProductAndUpdate(id: Int, updatedProduct: Product) {
        viewModelScope.launch {
            try {
                // Получение продукта ДО редактирования
                val productBefore = RetrofitClient.productsApiService.getProduct(id)
                Log.d(
                    "ProductLog",
                    "=== ДО РЕДАКТИРОВАНИЯ === " +
                            "ID: ${productBefore.id} | " +
                            "Название: ${productBefore.title} | " +
                            "Описание: ${productBefore.description} | " +
                            "Категория: ${productBefore.category} | " +
                            "Тэги: ${productBefore.tags?.joinToString(", ") ?: ""}"
                )

                // Обновление продукта
                val productAfter = RetrofitClient.productsApiService.updateProduct(id, updatedProduct)
                Log.d(
                    "ProductLog",
                    "=== ПОСЛЕ РЕДАКТИРОВАНИЯ === " +
                            "ID: ${productAfter.id} | " +
                            "Название: ${productAfter.title} | " +
                            "Описание: ${productAfter.description} | " +
                            "Категория: ${productAfter.category} | " +
                            "Тэги: ${productAfter.tags?.joinToString(", ") ?: ""}"
                )

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}
