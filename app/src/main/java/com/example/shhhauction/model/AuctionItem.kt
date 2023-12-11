package com.example.shhhauction.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

@Entity(tableName = "auctionItem")
data class AuctionItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "startingBid")
    val startingBid: Double,
    @ColumnInfo(name = "bidIncrement")
    val bidIncrement: Double,
    @ColumnInfo(name = "highestBid")
    var highestBid: Double,
) {
    fun AuctionItem.getFormattedBid(): String =
        NumberFormat.getCurrencyInstance().format(highestBid)
}