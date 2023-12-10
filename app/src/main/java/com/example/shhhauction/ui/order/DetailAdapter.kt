package com.example.shhhauction.ui.order

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shhhauction.data.DataSource.auctionItems
import com.example.shhhauction.databinding.FragmentDetailBinding
import com.example.shhhauction.databinding.ListtItemBinding
import com.example.shhhauction.model.AuctionItem

class DetailAdapter (): RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {


    private lateinit var context: Context

    class DetailViewHolder(private var binding: FragmentDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AuctionItem, context: Context){
            binding.detailItemName.text = item.name
            binding.detailItemBidIncrement.text = item.bidIncrement.toString()
            binding.detailItemHighestBid.text = item.highestBid.toString()
            binding.detailItemDesc.text = item.description
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewHolder {
        context = parent.context
        return DetailAdapter.DetailViewHolder(
            FragmentDetailBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
    return auctionItems.size
    }

}