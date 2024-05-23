package com.example.composestoreapp.models

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String,
    val rating: Rating
){
    val computedPrice get() = "$$price"

    //Si el text del titulo es muy largo, cortarlo y colocar puntos suspensivos
    val computedTitle get() = if(title.length > 10) title.substring(0,10) + "..." else title
}

val productList = List(10){
    Product(
        id = 1,
        category = "Electronics",
        description = "The best phone in the world",
        image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        price = 1000.0,
        rating = Rating(4, 4.5),
        title = "iPhone 12 Pro Max"
    )
}