package com.example.shhhauction.model

import java.text.NumberFormat

data class AuctionItem(
    val name: String,
    val description: String,
    val startingBid: Double,
    val bidIncrement: Double,
    var highestBid: Double,
) {
    fun getFormattedBid(): String = NumberFormat.getCurrencyInstance().format(highestBid)
}