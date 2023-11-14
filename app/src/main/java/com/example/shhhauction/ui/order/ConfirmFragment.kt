package com.example.shhhauction.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shhhauction.R
import com.example.shhhauction.databinding.FragmentConfirmBinding
import com.example.shhhauction.model.OrderViewModel

class ConfirmFragment : Fragment() {
    private var _binding: FragmentConfirmBinding? = null
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
        _binding = FragmentConfirmBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            confirmFragment = this@ConfirmFragment
        }
    }

    fun cancelBid(){
        findNavController().navigate(R.id.action_confirmFragment_to_listtFragment)
    }
    fun bidAndContinue(item: String){
        sharedViewModel.makeBid(item)
        findNavController().navigate(R.id.action_confirmFragment_to_listtFragment)
    }
}
