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

class AuctionItemAdapter(private val onItemClicked: (AuctionItem) -> Unit) :
        ListAdapter<AuctionItem, AuctionItemAdapter.AuctionItemViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuctionItemAdapter.AuctionItemViewHolder {
        return AuctionItemViewHolder(
            ListtItemBinding.inflate(
                LayoutInflater.from(
                    parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: AuctionItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(currentItem)
        }
        holder.bind(currentItem)

    }

    class AuctionItemViewHolder(private var binding: ListtItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(auctionItem: AuctionItem){
            binding.itemName.text = auctionItem.name
            binding.itemHighestBid.text = auctionItem.highestBid.toString()
        }

    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<AuctionItem>() {
            override fun areItemsTheSame(oldItem: AuctionItem, newItem: AuctionItem): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: AuctionItem, newItem: AuctionItem) : Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}