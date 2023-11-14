package com.example.shhhauction.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shhhauction.R
import com.example.shhhauction.databinding.FragmentListtBinding
import com.example.shhhauction.model.OrderViewModel

class ListtFragment : Fragment() {
    private var _binding: FragmentListtBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

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
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            listtFragment = this@ListtFragment
        }
        val adapter = AuctionItemAdapter(sharedViewModel.auctionItems)
        _binding?.recyclerListView?.adapter = adapter
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_listtFragment_to_detailFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
            _binding = null
        }

    }
