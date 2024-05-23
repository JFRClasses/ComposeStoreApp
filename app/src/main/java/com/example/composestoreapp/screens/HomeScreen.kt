package com.example.composestoreapp.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestoreapp.ProductService
import com.example.composestoreapp.components.ProductCard
import com.example.composestoreapp.models.Product
import com.example.composestoreapp.models.productList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen() {
    var products by remember { mutableStateOf(listOf<Product>())}
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        scope.launch {
            Log.d("HomeScreen", "LaunchedEffect")
            val BASE_URL = "https://fakestoreapi.com/"
            val builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductService::class.java)

            val response = builder.getProducts()
            Log.i("HomeScreen", response.toString())
            withContext(Dispatchers.IO) {
                products = response
                Log.i("HomeScreen", products.toString())
            }
        }
    }
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        columns = GridCells.Fixed(2)
    ) {

        items(products){ product ->
            ProductCard(product, modifier = Modifier.padding(5.dp))
        }

    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
