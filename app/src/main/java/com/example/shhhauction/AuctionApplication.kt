package com.example.shhhauction

import android.app.Application
import com.example.shhhauction.model.AuctionItem
import com.example.shhhauction.model.AuctionItemRoomDatabase

class AuctionApplication : Application() {
    val database: AuctionItemRoomDatabase by lazy { AuctionItemRoomDatabase.getDatabase(this)}
}