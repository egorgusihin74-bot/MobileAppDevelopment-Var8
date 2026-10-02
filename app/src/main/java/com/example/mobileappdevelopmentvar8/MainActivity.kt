package com.example.mobileappdevelopmentvar8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobileappdevelopmentvar8.ui.theme.MobileAppDevelopmentVar8Theme
import com.example.mobileappdevelopmentvar8.ui.viewModel.RecipeDeleteViewModel
import com.example.mobileappdevelopmentvar8.ui.viewModel.ProductViewModel
import com.example.mobileappdevelopmentvar8.data.model.Product

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileAppDevelopmentVar8Theme {
                val recipeDeleteViewModel: RecipeDeleteViewModel = viewModel()
                val productViewModel: ProductViewModel = viewModel()

                LaunchedEffect(Unit) {
                    // 4-я практическая работа: удаление рецепта
                    recipeDeleteViewModel.deleteRecipe()

                    // 3-я практическая работа: редактирование продукта
                    val productId = 48
                    val updatedProduct = Product(
                        id = productId,
                        title = "Беспроводные наушники SoundWave Pro",
                        description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                        category = "Аудиотехника",
                        tags = listOf("Наушники", "bluetooth", "шумоподавление", "беспроводные наушники", "гаджеты")
                    )
                    productViewModel.getProductAndUpdate(productId, updatedProduct)
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileAppDevelopmentVar8Theme {
        Greeting("Android")
    }
}
