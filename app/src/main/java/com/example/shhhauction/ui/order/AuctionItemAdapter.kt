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
import com.example.shhhauction.model.OrderViewModel

class AuctionItemAdapter(private val auctionItems: Map<>) :
        RecyclerView.Adapter<AuctionItemAdapter.AuctionItemViewHolder>() {


    private lateinit var  context: Context

            class AuctionItemViewHolder(private var binding: FragmentListtBinding) :
                    RecyclerView.ViewHolder(binding.root) {
                val item_name = binding.findViewById(R.id.item_name)
                    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuctionItemViewHolder {
        context = parent.context
        return AuctionItemViewHolder(
            FragmentListtBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return auctionItems.size
    }

    override fun onBindViewHolder(holder: AuctionItemViewHolder, position: Int) {
        val item = auctionItems[position]
        holder.item_name.text = item.name
        holder.item_highest_bid.text = item.highestBid
        holder.item_bid_increment.text = item.bidIncrement

    }

}