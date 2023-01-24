
package com.example.otg_campaigns.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.otg_campaigns.databinding.FragmentTransferToAccountBinding

class TransferToAccountFragment : Fragment() {
    lateinit var binding: FragmentTransferToAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransferToAccountBinding.inflate(inflater, container, false)

        hideFragmeng()
        return binding.root
    }

    private fun hideFragmeng() {
        binding.cancelTransferToAccount.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }
}
