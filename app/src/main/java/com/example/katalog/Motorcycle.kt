package com.example.katalog

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import com.example.katalog.data.Category
import kotlinx.android.parcel.Parcelize

@Parcelize
class Motorcycle(
    val brand: String,
    val model: String,
    val horsePower: Float,
    val category: Category,
    val photos: Array<Int>,
    val accessories: Array<String>

) : Parcelable {
    val isFavourite: MutableLiveData<Boolean> = MutableLiveData(false)

    fun switchFavourite() {
        isFavourite.value = !isFavourite.value!!
    }

    fun isFiltered(): Boolean {
        if (filterFavourite && !isFavourite.value!!) return false
        if (filterCategory != null && category != filterCategory) return false
        return true
    }

    companion object {
        var filterCategory: Category? = null
        var filterFavourite: Boolean = false
        fun factory(): MutableList<Motorcycle> =
            mutableListOf(
                Motorcycle(
                    "Kawasaki",
                    "Ninja 650",
                    68f,
                    Category.SPORT,
                    arrayOf(
                        R.drawable.ninja1,
                        R.drawable.ninja2,
                        R.drawable.ninja3,
                        R.drawable.ninja4
                    ),
                    arrayOf(
                        "Frame Slider Set",
                        "Seat Cowl, Candy Lime Green/777",
                        "Knee Pad Set",
                        "Ergo-Fit Extended Reach Seat"
                    )
                ),
                Motorcycle(
                    "Honda",
                    "Gold Wing",
                    126.5f,
                    Category.TOURER,
                    arrayOf(
                        R.drawable.goldwing1,
                        R.drawable.goldwing2,
                        R.drawable.goldwing3,
                        R.drawable.goldwing4,
                        R.drawable.goldwing5,
                        R.drawable.goldwing6
                    ),
                    arrayOf(
                        "Goldstrike Grips Black",
                        "Twinart Chrome Switch Panel Cover",
                        "Gold Wing Tour Tank Pouch - Show Chrome",
                        "Quick Detach Backrest Gold Wing Tour",
                        "Passenger Armrests"
                    )
                ),
                Motorcycle(
                    "Harley Davidson",
                    "Street Bob",
                    85.8f,
                    Category.CRUISER,
                    arrayOf(
                        R.drawable.streetbob1,
                        R.drawable.streetbob2,
                        R.drawable.streetbob3,
                        R.drawable.streetbob4
                    ),
                    arrayOf(
                        "Holdfast Two-Up Luggage Rack",
                        "Water Resistant Handlebar Mount Phone Carrier"
                    )
                ),
                Motorcycle(
                    "Yamaha",
                    "MT-09",
                    119f,
                    Category.NAKED,
                    arrayOf(
                        R.drawable.mt09_1,
                        R.drawable.mt09_2
                    ),
                    arrayOf(
                        "Yamaha 50L Top Case",
                        "Swingarm Spools",
                        "MT/FZ-09 Street Tag Eliminator",
                        "Rear Wheel Stand by Harris",
                        "C/5 Sport Series Levers by ASV Inventions"
                    )
                ),
                Motorcycle(
                    "Husqvarna",
                    "701 Supermoto",
                    73.8f,
                    Category.SUPERMOTO,
                    arrayOf(
                        R.drawable.h701_1,
                        R.drawable.h701_2
                    ),
                    arrayOf(
                        "Akrapovic \"Slip-On Line\"",
                        "Heated Grip Kit",
                        "Side Bag Set"
                    )
                ),
                Motorcycle(
                    "Kawasaki",
                    "Z H2",
                    200f,
                    Category.NAKED,
                    arrayOf(
                        R.drawable.z_h2_1,
                        R.drawable.z_h2_2,
                        R.drawable.z_h2_3,
                        R.drawable.z_h2_4
                    ),
                    arrayOf(
                        "Knee Pad Set",
                        "DC Power Outlet"
                    )
                ),
                Motorcycle(
                    "Yamaha",
                    "Star Venture",
                    85f,
                    Category.TOURER,
                    arrayOf(
                        R.drawable.starventure1,
                        R.drawable.starventure2,
                        R.drawable.starventure3
                    ),
                    arrayOf(
                        "Touring Trunk Rack",
                        "Touring Lower Fairing Wind Deflectors",
                        "Touring LED Auxiliary Lights"
                    )
                ),
                Motorcycle(
                    "Honda",
                    "CBR1000RR",
                214f,
                    Category.SPORT,
                    arrayOf(
                        R.drawable.cbr1000rr1,
                        R.drawable.cbr1000rr2,
                        R.drawable.cbr1000rr3
                    ),
                    arrayOf(
                        "No accessories available"
                    )
                )
            )

    }
}

