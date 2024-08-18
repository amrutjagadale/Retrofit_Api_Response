package com.example.retrofit_api_response

import android.icu.text.CaseMap.Title
import java.util.ArrayList
import java.util.concurrent.CountDownLatch


data class Product(
    var id : Int,
    var title: String,
    var price : Double,
    var description : String,
    var category : String,
    var image : String,
    var rating : Rating
)
data class Rating(
    var rate : Double,
    var count : Int
)
