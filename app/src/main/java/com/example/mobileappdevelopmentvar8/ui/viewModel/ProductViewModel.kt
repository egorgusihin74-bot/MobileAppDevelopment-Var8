package com.example.mobileappdevelopmentvar8.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar8.data.RetrofitClient
import com.example.mobileappdevelopmentvar8.data.model.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    fun updateProduct() {
        viewModelScope.launch {
            try {
                val id = 48

                val productBefore = RetrofitClient.productsApiService.getProduct(id)

                Log.d("RetrofitSuccess", "ID: ${productBefore.id}")
                Log.d("RetrofitSuccess", "Название: ${productBefore.title}")
                Log.d("RetrofitSuccess", "Описание: ${productBefore.description}")
                Log.d("RetrofitSuccess", "Категория: ${productBefore.category}")
                Log.d(
                    "RetrofitSuccess",
                    "Теги: ${productBefore.tags?.joinToString(", ") ?: ""}"
                )

                val product = productBefore.copy(
                    title = "Беспроводные наушники SoundWave Pro",
                    description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                    category = "Аудиотехника",
                    tags = listOf("Наушники", "bluetooth", "шумоподавление", "беспроводные наушники", "гаджеты")
                )

                val productAfter =
                    RetrofitClient.productsApiService.updateProduct(id, product)

                Log.d("RetrofitSuccess", "ID: ${productAfter.id}")
                Log.d("RetrofitSuccess", "Название: ${productAfter.title}")
                Log.d("RetrofitSuccess", "Описание: ${productAfter.description}")
                Log.d("RetrofitSuccess", "Категория: ${productAfter.category}")
                Log.d(
                    "RetrofitSuccess",
                    "Теги: ${productAfter.tags?.joinToString(", ") ?: ""}"
                )

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}
