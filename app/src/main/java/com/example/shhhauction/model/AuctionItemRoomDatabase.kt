package com.example.shhhauction.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [AuctionItem::class], version =1, exportSchema = false)
abstract class AuctionItemRoomDatabase : RoomDatabase() {
    abstract fun auctionItemDao(): AuctionItemDao

    companion object {
        @Volatile
        private var INSTANCE: AuctionItemRoomDatabase? = null
        fun getDatabase(context: Context): AuctionItemRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AuctionItemRoomDatabase::class.java,
                    "auction_item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}