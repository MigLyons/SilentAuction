package com.example.shhhauction.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AuctionItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(auctionItem: AuctionItem)
    @Update
    suspend fun update(auctionItem: AuctionItem)
    @Delete
    suspend fun delete(auctionItem: AuctionItem)

    @Query("SELECT * from auctionItem WHERE id = :id")
    fun getItem(id: Int): Flow<AuctionItem>

    @Query("SELECT * from auctionItem ORDER BY name ASC")
    fun getItems(): Flow<List<AuctionItem>>

}