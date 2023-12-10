package com.example.shhhauction.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import com.example.shhhauction.data.DataSource
import java.text.NumberFormat

//TODO: add highestBidder to AuctionItemModel
//todo: update auctionitems[item].highestBidder when makeBid(item);


class OrderViewModel(private val auctionItemDao: AuctionItemDao): ViewModel() {

    //map of auction items
    var auctionItems = DataSource.auctionItems

    //default values for auction item values
    //do I need any?
    private var _total = MutableLiveData(0.0)
    val total: LiveData<String> = _total.map{
        NumberFormat.getCurrencyInstance().format(it)
    }

    private var _bidList = mutableListOf<String>()
    val bidList = _bidList.toList()

    fun makeBid(item: String){
        //update item.highestBid
        auctionItems[item]!!.highestBid += auctionItems[item]!!.bidIncrement
        //update bidList
        _bidList.add(auctionItems[item]!!.name)
        //update subtotal: add bid to subtotal
        if(_total.value != null){
            _total.value = _total.value!! + auctionItems[item]!!.bidIncrement
        } else {
            _total.value = auctionItems[item]!!.bidIncrement
        }
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