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
import com.example.mobileappdevelopmentvar8.data.model.Product
import com.example.mobileappdevelopmentvar8.data.model.User
import com.example.mobileappdevelopmentvar8.data.model.UserAddress
import com.example.mobileappdevelopmentvar8.ui.theme.MobileAppDevelopmentVar8Theme
import com.example.mobileappdevelopmentvar8.ui.viewModel.ProductViewModel
import com.example.mobileappdevelopmentvar8.ui.viewModel.RecipeViewModel
import com.example.mobileappdevelopmentvar8.ui.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileAppDevelopmentVar8Theme {
                val recipeViewModel: RecipeViewModel = viewModel()

                LaunchedEffect(Unit) {
                    recipeViewModel.fetchRecipe()
                }

                val userViewModel: UserViewModel = viewModel()

                val userAddress = UserAddress(
                    address = "г. Заволжье, пр-т Мира, 18"
                )

                val user = User(
                    firstName = "Антон",
                    lastName = "Кудрин",
                    gender = "мужской",
                    address = userAddress
                )

                LaunchedEffect(Unit) {
                    userViewModel.addUser(user)
                }

                val productViewModel: ProductViewModel = viewModel()

                LaunchedEffect(Unit) {
                    productViewModel.getProduct()
                }

                val product = Product(
                    title = "Беспроводные наушники SoundWave Pro",
                    description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                    category = "Аудиотехника",
                    tags = listOf("Наушники", "bluetooth", "шумоподавление", "беспроводные наушники", "гаджеты")
                )

                LaunchedEffect(Unit) {
                    productViewModel.updateProduct(product)
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
