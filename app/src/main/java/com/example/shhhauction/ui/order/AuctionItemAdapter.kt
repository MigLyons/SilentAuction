package com.example.shhhauction.ui.order

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
//import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shhhauction.databinding.FragmentListtBinding
import com.example.shhhauction.databinding.ListtItemBinding
import com.example.shhhauction.model.AuctionItem
import androidx.recyclerview.widget.ListAdapter
import com.example.shhhauction.R
import com.example.shhhauction.data.DataSource.auctionItems
import com.example.shhhauction.databinding.FragmentDetailBinding
import com.example.shhhauction.model.OrderViewModel

class AuctionItemAdapter() :
        RecyclerView.Adapter<AuctionItemAdapter.AuctionItemViewHolder>() {


    private lateinit var  context: Context

            class AuctionItemViewHolder(private var binding: ListtItemBinding) :
                    RecyclerView.ViewHolder(binding.root) {

                        fun bind(item: AuctionItem, context: Context){
                            binding.itemName.text = item.name
                            binding.itemBidIncrement.text = item.bidIncrement.toString()
                            binding.itemHighestBid.text = item.highestBid.toString()
                        }

                    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuctionItemViewHolder {
        context = parent.context
        return AuctionItemViewHolder(
            ListtItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return auctionItems.size
    }

    override fun onBindViewHolder(holder: AuctionItemViewHolder, position: Int) {
    }

}