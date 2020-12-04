package com.example.katalog

class Motorcycle(
    val brand: String,
    val model: String,
    val horsePower: Float,
    val category: Category,
    val photos: Array<Int>
) {
    var isFavourite: Boolean = false
        private set

    fun switchFavourite() {
        isFavourite != isFavourite;
    }
}

enum class Category {
    SPORT,
    TOURER,
    NAKED,
    CHOPPER,
    SUPERMOTO
}