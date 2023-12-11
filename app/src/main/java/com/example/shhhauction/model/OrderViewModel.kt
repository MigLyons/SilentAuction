package com.example.shhhauction.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.text.NumberFormat

//TODO: add highestBidder to AuctionItemModel
//todo: update auctionitems[item].highestBidder when makeBid(item);

//todo: registerItem
//todo: getnewitementry
// todo:  edit item
//todo: delete item

//todo: recycler w database


class OrderViewModel(private val auctionItemDao: AuctionItemDao): ViewModel() {

    //map of auction items
    val auctionItems : LiveData<List<AuctionItem>> = auctionItemDao.getItems().asLiveData()


    private var _total = MutableLiveData(0.0)
    val total: LiveData<String> = _total.map{
        NumberFormat.getCurrencyInstance().format(it)
    }

    private var _bidList = mutableListOf<Int>()
    val bidList = _bidList.toList()

    fun makeBid(auctionItem: AuctionItem){
        //update item.highestBid
        auctionItem.highestBid += auctionItem.bidIncrement
        //update bidList
        _bidList.add(auctionItem.id)
        //update subtotal: add bid to subtotal
        if(_total.value != null){
            _total.value = _total.value!! + auctionItem.bidIncrement
        } else {
            _total.value = auctionItem.bidIncrement
        }
    }

    fun retrieveItem(id: Int): LiveData<AuctionItem> {
        return auctionItemDao.getItem(id).asLiveData()
    }

    fun deleteItem(auctionItem: AuctionItem){
        viewModelScope.launch{
            auctionItemDao.delete(auctionItem)
        }
    }

    private fun insertItem(auctionItem: AuctionItem){
        viewModelScope.launch {
            auctionItemDao.insert(auctionItem)
        }
    }

    private fun getNewItemEntry(name: String, description: String, highestBid: String, bidIncrement: String, startingBid: String) : AuctionItem {
        return AuctionItem(
            name = name,
            description = description,
            highestBid = highestBid.toDouble(),
            bidIncrement = bidIncrement.toDouble(),
            startingBid = startingBid.toDouble(),
        )
        }


    private fun updateItem(auctionItem: AuctionItem) {
        viewModelScope.launch {
            auctionItemDao.update(auctionItem)
        }
    }

    fun addNewItem(name: String, description: String, highestBid: String, startingBid: String, bidIncrement: String) {
        val newItem = getNewItemEntry(name, description, highestBid, startingBid, bidIncrement)
        insertItem(newItem)
    }
    fun isEntryValid(name: String, description: String, bidIncrement: String): Boolean {
        if (name.isBlank() || bidIncrement.isBlank() || description.isBlank()) {
            return false
        }
        return true
    }



    private fun getUpdatedItemEntry(
        id: Int,
        itemName: String,
        description: String,
        highestBid: String,
        bidIncrement: String,
        startingBid: String
    ): AuctionItem {
        return AuctionItem(
            id = id,
            name = itemName,
            description = description,
            highestBid = highestBid.toDouble(),
            bidIncrement = bidIncrement.toDouble(),
            startingBid = startingBid.toDouble(),
        )
    }

    fun updateItem(
        id: Int,
        name: String,
        description: String,
        highestBid: String,
        bidIncrement: String,
        startingBid: String
    ) {
        val updatedItem = getUpdatedItemEntry(id, name, description, highestBid, bidIncrement, startingBid)
        updateItem(updatedItem)
    }




}


class AuctionViewModelFactory(private val auctionItemDao: AuctionItemDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OrderViewModel(auctionItemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}