package com.example.shhhauction.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shhhauction.AuctionApplication
import com.example.shhhauction.R
import com.example.shhhauction.databinding.FragmentDetailBinding
import com.example.shhhauction.model.AuctionItem
import com.example.shhhauction.model.OrderViewModel
import com.example.shhhauction.model.AuctionViewModelFactory

class DetailFragment : Fragment() {

    private val viewModel: OrderViewModel by activityViewModels {
        AuctionViewModelFactory(
            (activity?.application as AuctionApplication
        ).database.auctionItemDao()
        )

    }
    private val navigationArgs: ItemDetailFragmentArgs by navArgs()
    lateinit var auctionItem: AuctionItem


    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }


    //I'm modifying this to be like inventoryapp.itemdetailfragment to be able to do the user input stuff
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = navigationArgs.auctionItemId
        viewModel.retrieveItem(id).observe(this.viewLifecycleOwner) {
            selectedItem ->
            item = selectedItem
            bind(item)
        }

        /*
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            detailFragment = this@DetailFragment
        }
        */

    }


    fun goToNextScreen() {
        findNavController().navigate(R.id.action_detailFragment_to_confirmFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}