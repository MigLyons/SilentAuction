package com.example.shhhauction.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shhhauction.AuctionApplication
import com.example.shhhauction.R
import com.example.shhhauction.databinding.FragmentListtBinding
import com.example.shhhauction.databinding.FragmentSummaryBinding
import com.example.shhhauction.model.AuctionItemDao
import com.example.shhhauction.model.AuctionViewModelFactory
import com.example.shhhauction.model.OrderViewModel

class ListtFragment : Fragment() {
    private var _binding: FragmentListtBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels{
        AuctionViewModelFactory(
            (activity?.application as AuctionApplication).database.auctionItemDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListtBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AuctionItemAdapter{
            val action = (ListtFragmentDirections.actionListtFragmentToDetailFragment(it.id))
            this.findNavController().navigate(action)
        }
        _binding?.recyclerListView?.adapter = adapter
        sharedViewModel.auctionItems.observe(this.viewLifecycleOwner){ items ->
            items.let {
                adapter.submitList(it)
            }
        }
        binding.recyclerListView.layoutManager = LinearLayoutManager(this.context)
        binding.floatingActionButton.setOnClickListener {
            val action = ListtFragmentDirections.actionListtFragmentToAddFragment()
            this.findNavController().navigate(action)
        }
        /*binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            listtFragment = this@ListtFragment
        }*/
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
            _binding = null
        } */

    }
