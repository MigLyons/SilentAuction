package com.example.shhhauction.ui.order

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shhhauction.AuctionApplication
import com.example.shhhauction.databinding.FragmentAddBinding
import com.example.shhhauction.model.AuctionItem
import com.example.shhhauction.model.AuctionViewModelFactory
import com.example.shhhauction.model.OrderViewModel
import org.w3c.dom.Text

class AddFragment : Fragment() {
    private val viewModel: OrderViewModel by activityViewModels {
        AuctionViewModelFactory(
            (activity?.application as AuctionApplication).database
                .auctionItemDao()
        )
    }
    lateinit var auctionItem: AuctionItem
    private val navigationArgs: DetailFragmentArgs by navArgs()
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.itemName.text.toString(),
            binding.itemDescription.text.toString(),
            binding.bidIncrement.text.toString()
        )
    }

    private fun addNewItem(){
        if(isEntryValid()) {
            viewModel.addNewItem(
                binding.itemName.text.toString(),
                binding.itemDescription.text.toString(),
                binding.startingBid.text.toString(),
                binding.bidIncrement.text.toString(),
                binding.highestBid.text.toString()
                )
        }
        val action = AddFragmentDirections.actionAddFragmentToListtFragment()
        findNavController().navigate(action)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = navigationArgs.itemId
        if (id > 0) {
            viewModel.retrieveItem(id).observe(this.viewLifecycleOwner) { selectedItem ->
                auctionItem = selectedItem
                bind(auctionItem)
            }
        } else {
            binding.saveAction.setOnClickListener {
                addNewItem()
            }
            binding.saveAction.setOnClickListener {
                addNewItem()
            }
        }
    }


    private fun bind(auctionItem: AuctionItem) {
        val price = "%.2f".format(auctionItem.highestBid)
        binding.apply {
            itemName.setText(auctionItem.name, TextView.BufferType.SPANNABLE)
            itemDescription.setText(auctionItem.description, TextView.BufferType.SPANNABLE)
            bidIncrement.setText(auctionItem.bidIncrement.toString(), TextView.BufferType.SPANNABLE)
            startingBid.setText(auctionItem.startingBid.toString(), TextView.BufferType.SPANNABLE)
            highestBid.setText(price, TextView.BufferType.SPANNABLE)
            saveAction.setOnClickListener { updateItem() }
        }
    }

    private fun updateItem() {
        if (isEntryValid()) {
            viewModel.updateItem(
                this.navigationArgs.itemId,
                this.binding.itemName.text.toString(),
                this.binding.itemDescription.text.toString(),
                this.binding.highestBid.text.toString(),
                this.binding.bidIncrement.text.toString(),
                this.binding.startingBid.text.toString(),
            )
            val action = AddFragmentDirections.actionAddFragmentToListtFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }



}